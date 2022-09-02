package com.astrog.particlesystem.particle_system.core.emitter

import com.astrog.particlesystem.particle_system.utils.Vector2d
import com.astrog.particlesystem.particle_system.core.Particle

class AttractEmitter(val center: Vector2d) : Emitter {

    override fun move(particle: Particle, otherParticles: List<Particle>, deltaTime: Float) {
        val positionDiff = center - particle.position
        val acceleration = G * 1 * 1 / positionDiff.length
        val velocityOffset = positionDiff.identity * acceleration
        particle.velocity += velocityOffset
    }

    companion object {
        const val G = 1000
    }

}