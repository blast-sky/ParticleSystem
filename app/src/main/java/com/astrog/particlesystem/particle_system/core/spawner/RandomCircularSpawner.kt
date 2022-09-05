package com.astrog.particlesystem.particle_system.core.spawner

import com.astrog.particlesystem.particle_system.core.utils.Rect
import com.astrog.particlesystem.particle_system.core.utils.Vector2d
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin
import kotlin.random.Random

class RandomCircularSpawner(private val radius: Float = 100f) : Spawner {

    override fun spawn(rect: Rect): Vector2d {
        val angle = Random.nextFloat() * CIRCULAR
        val distanceFromCenter = Random.nextFloat() * radius

        val offsetFromCenterX = cos(angle)
        val offsetFromCenterY = sin(angle)

        return rect.center + Vector2d(offsetFromCenterX, offsetFromCenterY) * distanceFromCenter
    }

    private companion object {
        const val CIRCULAR = 2 * PI.toFloat()
    }
}