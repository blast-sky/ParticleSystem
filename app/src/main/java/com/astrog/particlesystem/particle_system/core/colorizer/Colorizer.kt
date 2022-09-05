package com.astrog.particlesystem.particle_system.core.colorizer

import com.astrog.particlesystem.particle_system.core.MassiveOperation
import com.astrog.particlesystem.particle_system.core.system.Particle
import com.astrog.particlesystem.particle_system.core.utils.Color

interface Colorizer : MassiveOperation<Color> {

    fun colorize(index: Int, particles: List<Particle>, deltaTimeMillis: Float): Color

    fun massiveColorize(particles: List<Particle>, deltaTimeMillis: Float) =
        massiveOperation(particles.indices) { index ->
            colorize(index, particles, deltaTimeMillis)
        }

}