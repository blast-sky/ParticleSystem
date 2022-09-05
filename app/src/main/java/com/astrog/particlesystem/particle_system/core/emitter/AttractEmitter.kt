package com.astrog.particlesystem.particle_system.core.emitter

import com.astrog.particlesystem.particle_system.core.utils.Vector2d
import com.astrog.particlesystem.particle_system.core.system.Particle
import kotlin.math.absoluteValue

class AttractEmitter(particleCount: Int, var center: Vector2d) : Emitter {

    private val velocities = MutableList(particleCount) { Vector2d() }

    override fun move(index: Int, particles: List<Particle>, deltaTime: Float): Vector2d {
        val particle = particles[index]
        val positionDiff = center - particle.position
        val diffLength = minOf(positionDiff.length, 300f)
        val acceleration = G * 1 * 1 / maxOf(diffLength, 0.01f)
        val velocityOffset = positionDiff.identity * acceleration

        var newVelocity = velocities[index] + velocityOffset
        if (newVelocity.squareLength > MAX_VELOCITY * MAX_VELOCITY) {
            newVelocity /= newVelocity.length.absoluteValue / MAX_VELOCITY
        }

        velocities[index] = newVelocity
        return particle.position + velocities[index] * deltaTime / 1000f
    }

    companion object {
        const val G = 3000
        const val MAX_VELOCITY = 700
    }

}