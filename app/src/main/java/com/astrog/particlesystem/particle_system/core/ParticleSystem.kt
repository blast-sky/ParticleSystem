package com.astrog.particlesystem.particle_system.core

import com.astrog.particlesystem.particle_system.core.colorizer.Colorizer
import com.astrog.particlesystem.particle_system.core.emitter.Emitter
import com.astrog.particlesystem.particle_system.core.lifecycle.LifecycleState
import com.astrog.particlesystem.particle_system.core.lifecycle.ParticleLifecycle
import com.astrog.particlesystem.particle_system.core.spawner.Spawner
import com.astrog.particlesystem.particle_system.core.utils.Rect

class ParticleSystem(
    private val particleCount: Int,
    private val viewRect: Rect,
    private val emitter: Emitter,
    private val colorizer: Colorizer,
    private val lifecycle: ParticleLifecycle,
    private val spawner: Spawner,
) {

    val particles = List<Particle>(particleCount) { Particle.Point(spawner.spawn(viewRect)) }

    fun update(secDeltaTime: Float) {
        when (lifecycle.getState(secDeltaTime)) {
            is LifecycleState.Dead -> return
            is LifecycleState.Alive -> Unit
        }
        for (particle in particles) {
            emitter.move(particle, particles, secDeltaTime)
            colorizer.colorize(particle, particles, secDeltaTime)
            particle.updatePosition(secDeltaTime)
        }
    }

}