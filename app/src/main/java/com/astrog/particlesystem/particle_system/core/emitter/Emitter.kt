package com.astrog.particlesystem.particle_system.core.emitter

import com.astrog.particlesystem.particle_system.core.Particle

interface Emitter {

    fun move(particle: Particle, otherParticles: List<Particle>, deltaTime: Float)

}