package com.astrog.particlesystem.particle_system.core.colorizer

import com.astrog.particlesystem.particle_system.core.Particle

class RainbowColorizer : Colorizer {

    override fun colorize(particle: Particle, otherParticles: List<Particle>, deltaTime: Float) {
        val colorOffset = deltaTime / 10
        particle.color += colorOffset
    }

}