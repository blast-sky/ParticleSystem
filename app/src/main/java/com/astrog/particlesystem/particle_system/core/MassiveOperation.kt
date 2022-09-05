package com.astrog.particlesystem.particle_system.core

interface MassiveOperation<T> {

    fun massiveOperation(
        indexRange: IntRange,
        singleOperation: (index: Int) -> T
    ): List<T> {
        val resList = mutableListOf<T>()
        for (i in indexRange)
            resList += singleOperation.invoke(i)
        return resList
    }

}