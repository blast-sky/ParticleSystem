package com.astrog.particlesystem.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.astrog.particlesystem.particle_system.presentation.ParticleSystemCanvas

@Composable
fun MainScreen() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.Black
    ) {
        ParticleSystemCanvas()
    }
}