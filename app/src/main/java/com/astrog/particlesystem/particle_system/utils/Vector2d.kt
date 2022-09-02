package com.astrog.particlesystem.particle_system.utils

import kotlin.math.sqrt

data class Vector2d(val x: Float = 0f, val y: Float = 0f) {

    val length get() = sqrt(squareLength)
    val squareLength get() = x * x + y * y
    val identity get() = this / length


    operator fun plus(other: Vector2d) = Vector2d(x + other.x, y + other.y)
    operator fun minus(other: Vector2d) = Vector2d(x - other.x, y - other.y)
    operator fun times(float: Float) = Vector2d(x * float, y * float)
    operator fun div(float: Float) = Vector2d(x / float, y / float)
    
}
