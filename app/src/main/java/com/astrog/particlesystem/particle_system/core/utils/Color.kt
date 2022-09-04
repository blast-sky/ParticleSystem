package com.astrog.particlesystem.particle_system.core.utils

import androidx.annotation.FloatRange

data class Color(
    @FloatRange(from = 0.0, to = 1.0) val r: Float = 1f,
    @FloatRange(from = 0.0, to = 1.0) val g: Float = 1f,
    @FloatRange(from = 0.0, to = 1.0) val b: Float = 1f,
    @FloatRange(from = 0.0, to = 1.0) val a: Float = 1f,
) {

    operator fun plus(float: Float) =
        Color(between(r + float), between(g + float), between(b + float), a)

    private fun between(value: Float, from: Float = 0f, to: Float = 1f) =
        minOf(maxOf(value, 0f), 1f)

}