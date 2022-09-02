package com.astrog.particlesystem.particle_system.core.lifecycle

interface ParticleLifecycle {

    fun getState(deltaTime: Float): LifecycleState

}

sealed class LifecycleState {

    object Alive : LifecycleState()

    object Dead : LifecycleState()

}