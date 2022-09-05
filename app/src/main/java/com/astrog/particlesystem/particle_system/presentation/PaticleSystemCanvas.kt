package com.astrog.particlesystem.particle_system.presentation

import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import com.astrog.particlesystem.particle_system.core.system.Particle
import com.astrog.particlesystem.particle_system.core.system.ParticleSystem
import com.astrog.particlesystem.particle_system.core.colorizer.RainbowColorizer
import com.astrog.particlesystem.particle_system.core.emitter.AttractEmitter
import com.astrog.particlesystem.particle_system.core.lifecycle.InfiniteLifecycle
import com.astrog.particlesystem.particle_system.core.spawner.RandomCircularSpawner
import com.astrog.particlesystem.particle_system.core.utils.Rect
import com.astrog.particlesystem.particle_system.core.utils.Vector2d

@Composable
fun ParticleSystemCanvas(modifier: Modifier = Modifier) {
    var isNeedUpdate by remember { mutableStateOf(true) }
    val particleCount = 100
    val emitter by remember {
        derivedStateOf {
            AttractEmitter(particleCount, Vector2d(100f, 100f))
        }
    }

    val particleSystem = remember {
        ParticleSystem(
            particleCount,
            Rect(Vector2d(0f, 0f), Vector2d(1000f, 1000f)),
            emitter,
            RainbowColorizer(particleCount),
            InfiniteLifecycle(),
            RandomCircularSpawner(1000f),
        )
    }

    LaunchedEffect(Unit) {
        var prevTime: Long? = null
        while (true) {
            withFrameMillis { frameTimeMillis ->
                val diff = prevTime?.let { frameTimeMillis - it } ?: 0
                particleSystem.update(diff.toFloat())
                isNeedUpdate = true
                prevTime = frameTimeMillis
            }
        }
    }

    Box(modifier = modifier.pointerInput(Unit) {
        detectTapGestures { offset ->
            emitter.center = offset.toVector2d()
        }
    }) {
        if (isNeedUpdate) {
            particleSystem.particlesToDraw.forEach { particle ->
                when (particle) {
                    is Particle.Point -> PointParticle(particle, Modifier)
                }
            }
            isNeedUpdate = false
        }
    }
}