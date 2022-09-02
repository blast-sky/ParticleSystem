package com.astrog.particlesystem.particle_system.core

import android.graphics.RectF
import com.astrog.particlesystem.particle_system.core.colorizer.Colorizer
import com.astrog.particlesystem.particle_system.core.emitter.Emitter
import com.astrog.particlesystem.particle_system.core.lifecycle.LifecycleState
import com.astrog.particlesystem.particle_system.core.lifecycle.ParticleLifecycle
import com.astrog.particlesystem.particle_system.utils.Vector2d

class ParticleSystem(
    private val particleCount: Int,
//    private val viewRect: RectF,
    private val emitter: Emitter,
    private val colorizer: Colorizer,
    private val lifecycle: ParticleLifecycle,
) {

    val particles = List<Particle>(particleCount) { Particle.Point(Vector2d(10f, 10f)) }

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