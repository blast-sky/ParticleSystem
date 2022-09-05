package com.astrog.particlesystem.particle_system.core.colorizer

import com.astrog.particlesystem.particle_system.core.system.Particle
import com.astrog.particlesystem.particle_system.core.utils.Color

class RainbowColorizer(particleCount: Int) : Colorizer {

    private sealed class ColorDirection {

        abstract fun isFinished(color: Color): Boolean

        abstract fun updateColor(color: Color, deltaTimeMillis: Float): Color

        object FromRedToGreen : ColorDirection() {
            override fun isFinished(color: Color): Boolean = (color.r == 0f)
            override fun updateColor(color: Color, deltaTimeMillis: Float): Color {
                val offset = deltaTimeMillis / colorChangeTime
                val newColorR = maxOf(0f, color.r - offset)
                val newColorG = minOf(1f, color.g + offset)
                return Color(r = newColorR, g = newColorG, b = color.b)
            }
        }

        object FromGreenToBlue : ColorDirection() {
            override fun isFinished(color: Color): Boolean = (color.g == 0f)
            override fun updateColor(color: Color, deltaTimeMillis: Float): Color {
                val offset = deltaTimeMillis / colorChangeTime
                val newColorG = maxOf(0f, color.g - offset)
                val newColorB = minOf(1f, color.b + offset)
                return Color(r = color.r, g = newColorG, b = newColorB)
            }
        }

        object FromBlueToRed : ColorDirection() {
            override fun isFinished(color: Color): Boolean = (color.b == 0f)
            override fun updateColor(color: Color, deltaTimeMillis: Float): Color {
                val offset = deltaTimeMillis / colorChangeTime
                val newColorB = maxOf(0f, color.b - offset)
                val newColorR = minOf(1f, color.r + offset)
                return Color(r = newColorR, g = color.g, b = newColorB)
            }
        }

    }

    private val directions = MutableList(particleCount) { num ->
        when {
            num % 3 == 0 -> ColorDirection.FromBlueToRed
            num % 3 == 1 -> ColorDirection.FromRedToGreen
            num % 3 == 2 -> ColorDirection.FromGreenToBlue
            else -> ColorDirection.FromBlueToRed
        }
    }

    override fun colorize(
        index: Int,
        particles: List<Particle>,
        deltaTimeMillis: Float
    ): Color {
        val curColor = particles[index].color
        val direction = directions[index]
        val newColor = direction.updateColor(curColor, deltaTimeMillis)
        if (direction.isFinished(newColor)) {
            directions[index] =
                when (direction) {
                    ColorDirection.FromBlueToRed -> ColorDirection.FromRedToGreen
                    ColorDirection.FromGreenToBlue -> ColorDirection.FromBlueToRed
                    ColorDirection.FromRedToGreen -> ColorDirection.FromGreenToBlue
                }
        }
        return newColor
    }

    private companion object {
        const val colorChangeTime = 5000f
    }

}