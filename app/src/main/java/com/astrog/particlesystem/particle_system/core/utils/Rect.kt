package com.astrog.particlesystem.particle_system.core.utils

data class Rect(val start: Vector2d, val end: Vector2d) {

    val center by lazy { (start + end) / 2f }

}