package com.astrog.particlesystem.particle_system.core.system

import com.astrog.particlesystem.particle_system.core.utils.Vector2d

class DrawAndPhysicsFrameUpdater(
    particleCount: Int,
    private val physicalTimer: PhysicalTimer,
    private val spawnFun: () -> Vector2d,
    private val updateFun: (prev: List<Particle>, cur: List<Particle>, Float) -> Unit,
) {

    private val firstParticleList = List(particleCount) { Particle.Point(spawnFun.invoke()) }

    val particlesToDraw: List<Particle>
        get() = firstParticleList

    fun tryUpdate(deltaTimeMillis: Float) {
        if (physicalTimer.isNeedRecomputePhysics(deltaTimeMillis)) {
            updateFun(firstParticleList, firstParticleList, deltaTimeMillis)
        }
    }

}