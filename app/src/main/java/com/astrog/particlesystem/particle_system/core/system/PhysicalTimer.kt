package com.astrog.particlesystem.particle_system.core.system

class PhysicalTimer(updateFrameInSecond: UInt = 50u) {

    private val deltaTimeMills = 1000f / updateFrameInSecond.toFloat()

    private var timeAccumulator = 0f

    fun isNeedRecomputePhysics(deltaMillis: Float): Boolean {
        timeAccumulator += deltaMillis
        if(timeAccumulator >= deltaTimeMills) {
            timeAccumulator -= deltaMillis
            return true
        }
        return false
    }

}