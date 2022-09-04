package com.astrog.particlesystem.particle_system.presentation

import androidx.compose.ui.geometry.Offset
import com.astrog.particlesystem.particle_system.core.utils.Vector2d

fun com.astrog.particlesystem.particle_system.core.utils.Color.toColor() =
    androidx.compose.ui.graphics.Color(r, g, b, a)

fun Offset.toVector2d() = Vector2d(this.x, this.y)