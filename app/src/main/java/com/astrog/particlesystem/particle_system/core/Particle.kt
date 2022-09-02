package com.astrog.particlesystem.particle_system.core

import com.astrog.particlesystem.particle_system.utils.Color
import com.astrog.particlesystem.particle_system.utils.Vector2d

sealed class Particle(
    open var position: Vector2d = Vector2d(),
    open var rotation: Float = 0f,
    open var velocity: Vector2d = Vector2d(),
    open var color: Color = Color(),
) {

    fun updatePosition(secDeltaTime: Float) {
        position += velocity * secDeltaTime
    }

    class Point(
        override var position: Vector2d = Vector2d(),
        override var color: Color = Color()
    ) : Particle()

}