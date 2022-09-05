package com.astrog.particlesystem.particle_system.core.lifecycle

interface ParticleLifecycle {

    fun getState(deltaTimeMillis: Float): LifecycleState

}

sealed class LifecycleState {

    object Alive : LifecycleState()

    object Dead : LifecycleState()

}