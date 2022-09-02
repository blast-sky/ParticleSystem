package com.astrog.particlesystem.particle_system.core.lifecycle

class InfiniteLifecycle : ParticleLifecycle {

    override fun getState(deltaTime: Float): LifecycleState = LifecycleState.Alive

}