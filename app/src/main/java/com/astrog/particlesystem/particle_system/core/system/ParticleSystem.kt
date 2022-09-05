package com.astrog.particlesystem.particle_system.core.system

import com.astrog.particlesystem.particle_system.core.colorizer.Colorizer
import com.astrog.particlesystem.particle_system.core.emitter.Emitter
import com.astrog.particlesystem.particle_system.core.lifecycle.LifecycleState
import com.astrog.particlesystem.particle_system.core.lifecycle.ParticleLifecycle
import com.astrog.particlesystem.particle_system.core.spawner.Spawner
import com.astrog.particlesystem.particle_system.core.utils.Rect

class ParticleSystem(
    particleCount: Int,
    private val viewRect: Rect,
    private val emitter: Emitter,
    private val colorizer: Colorizer,
    private val lifecycle: ParticleLifecycle,
    private val spawner: Spawner,
) {

    private val drawAndPhysicsFrameUpdater =
        DrawAndPhysicsFrameUpdater(
            particleCount,
            PhysicalTimer(),
            { spawner.spawn(viewRect) },
            this::updateParticles
        )

    private fun updateParticles(
        prevParticles: List<Particle>,
        curParticles: List<Particle>,
        deltaTimeMillis: Float,
    ) {
        when (lifecycle.getState(deltaTimeMillis)) {
            is LifecycleState.Dead -> return
            is LifecycleState.Alive -> Unit
        }
        val newPositions = emitter.massiveMove(prevParticles, deltaTimeMillis)
        val newColors = colorizer.massiveColorize(prevParticles, deltaTimeMillis)
        curParticles.forEachIndexed { index, particle ->
            with(particle) {
                color = newColors[index]
                position = newPositions[index]
            }
        }
    }

    val particlesToDraw get() = drawAndPhysicsFrameUpdater.particlesToDraw

    fun update(deltaTimeMillis: Float) = drawAndPhysicsFrameUpdater.tryUpdate(deltaTimeMillis)
}