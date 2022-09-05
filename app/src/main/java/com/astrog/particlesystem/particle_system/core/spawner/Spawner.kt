package com.astrog.particlesystem.particle_system.core.spawner

import com.astrog.particlesystem.particle_system.core.utils.Rect
import com.astrog.particlesystem.particle_system.core.utils.Vector2d

interface Spawner {

    fun spawn(rect: Rect): Vector2d

    fun massiveSpawn(rect: Rect, particleCount: Int): List<Vector2d> {
        val spawnList = MutableList(particleCount) { Vector2d() }
        for (i in 0 until particleCount) {
            spawnList[i] = spawn(rect)
        }
        return spawnList
    }

}