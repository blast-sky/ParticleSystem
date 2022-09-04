package com.astrog.particlesystem.particle_system.presentation

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.input.pointer.pointerInput
import com.astrog.particlesystem.particle_system.core.Particle
import com.astrog.particlesystem.particle_system.core.ParticleSystem
import com.astrog.particlesystem.particle_system.core.colorizer.RainbowColorizer
import com.astrog.particlesystem.particle_system.core.emitter.AttractEmitter
import com.astrog.particlesystem.particle_system.core.lifecycle.InfiniteLifecycle
import com.astrog.particlesystem.particle_system.core.spawner.CircularSpawner
import com.astrog.particlesystem.particle_system.core.utils.Rect
import com.astrog.particlesystem.particle_system.core.utils.Vector2d

@Composable
fun ParticleSystemCanvas(modifier: Modifier = Modifier) {
    var isNeedUpdate by remember { mutableStateOf(true) }
    val emitter by remember {
        derivedStateOf {
            AttractEmitter(Vector2d(100f, 100f))
        }
    }

    val particleSystem = remember {
        ParticleSystem(
            particleCount = 10,
            Rect(Vector2d(0f, 0f), Vector2d(2500f, 2500f)),
            emitter,
            RainbowColorizer(),
            InfiniteLifecycle(),
            CircularSpawner(),
        )
    }

    LaunchedEffect(Unit) {
        var prevTime: Long? = null
        while (true) {
            withFrameMillis { frameTimeMillis ->
                val diff = prevTime?.let { frameTimeMillis - it } ?: 0
                particleSystem.update(diff.toFloat() / 1000)
                isNeedUpdate = true
                prevTime = frameTimeMillis
                Log.d("MY_TAG", particleSystem.particles.first().position.toString())
            }
        }
    }

    Box(modifier = modifier.pointerInput(Unit) {
        detectTapGestures { offset ->
            emitter.center = offset.toVector2d()
        }
    }) {
        if (isNeedUpdate) {
            particleSystem.particles.forEach { particle ->
                Log.d("MY_TAG", particle.position.toString())
                when (particle) {
                    is Particle.Point -> PointParticle(particle, Modifier)
                }
            }
            isNeedUpdate = false
        }
    }
}