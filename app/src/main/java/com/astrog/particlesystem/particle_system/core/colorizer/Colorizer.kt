package com.astrog.particlesystem.particle_system.core.colorizer

import com.astrog.particlesystem.particle_system.core.Particle

interface Colorizer {

    fun colorize(particle: Particle, otherParticles: List<Particle>, deltaTime: Float)

}