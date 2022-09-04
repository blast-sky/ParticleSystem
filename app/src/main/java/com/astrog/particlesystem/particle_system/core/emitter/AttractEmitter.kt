package com.astrog.particlesystem.particle_system.core.emitter

import com.astrog.particlesystem.particle_system.core.utils.Vector2d
import com.astrog.particlesystem.particle_system.core.Particle
import kotlin.math.absoluteValue

class AttractEmitter(var center: Vector2d) : Emitter {

    override fun move(particle: Particle, otherParticles: List<Particle>, deltaTime: Float) {
        val positionDiff = center - particle.position
        val acceleration = G * 1 * 1 / positionDiff.length
        val velocityOffset = positionDiff.identity * acceleration

        var newVelocity = particle.velocity + velocityOffset
        if (newVelocity.squareLength > MAX_VELOCITY * MAX_VELOCITY) {
            newVelocity /= newVelocity.length.absoluteValue / MAX_VELOCITY
        }

        particle.velocity = newVelocity
    }

    companion object {
        const val G = 1000
        const val MAX_VELOCITY = 500
    }

}