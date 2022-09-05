package com.astrog.particlesystem.particle_system.core.system

import com.astrog.particlesystem.particle_system.core.utils.Color
import com.astrog.particlesystem.particle_system.core.utils.Vector2d

sealed class Particle(
    open var position: Vector2d = Vector2d(),
    open var rotation: Float = 0f,
    open var color: Color = Color(),
) {

    data class Point(
        override var position: Vector2d = Vector2d(),
        override var color: Color = Color()
    ) : Particle()

}