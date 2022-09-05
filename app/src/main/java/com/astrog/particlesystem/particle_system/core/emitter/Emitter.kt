package com.astrog.particlesystem.particle_system.core.emitter

import com.astrog.particlesystem.particle_system.core.system.Particle
import com.astrog.particlesystem.particle_system.core.utils.Vector2d

interface Emitter {

    fun move(index: Int, particles: List<Particle>, deltaTime: Float): Vector2d

    fun massiveMove(particles: List<Particle>, deltaTime: Float): List<Vector2d> {
        val resList = mutableListOf<Vector2d>()
        for (i in particles.indices) {
            resList += move(i, particles, deltaTime)
        }
        return resList
    }

}