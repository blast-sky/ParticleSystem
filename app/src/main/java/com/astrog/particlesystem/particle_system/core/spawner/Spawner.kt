package com.astrog.particlesystem.particle_system.core.spawner

import com.astrog.particlesystem.particle_system.core.utils.Rect
import com.astrog.particlesystem.particle_system.core.utils.Vector2d

interface Spawner {

    fun spawn(rect: Rect): Vector2d

}