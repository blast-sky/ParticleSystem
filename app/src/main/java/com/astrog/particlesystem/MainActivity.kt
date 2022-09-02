package com.astrog.particlesystem

import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.astrog.particlesystem.presentation.MainScreen
import com.astrog.particlesystem.ui.theme.ParticleSystemTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ParticleSystemTheme {
                MainScreen()
            }
        }
    }
}