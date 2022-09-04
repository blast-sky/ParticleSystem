package com.astrog.particlesystem.particle_system.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import com.astrog.particlesystem.particle_system.core.Particle

@Composable
fun PointParticle(particle: Particle.Point, modifier: Modifier = Modifier) {
    val density = LocalDensity.current
    with(density) {
        Box(
            modifier = modifier
                .offset(particle.position.x.toDp(), particle.position.y.toDp())
                .size(2.dp)
                .clip(CircleShape)
                .background(particle.color.toColor())
        )
    }
}