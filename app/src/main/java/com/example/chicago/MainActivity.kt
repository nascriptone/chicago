package com.example.chicago

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.ui.Modifier
import com.example.chicago.ui.ChicagoApp
import com.example.chicago.ui.theme.ChicagoTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ChicagoTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    val windowSize = calculateWindowSizeClass(this)
                    ChicagoApp(
                        windowSize = windowSize.widthSizeClass,
                    )
                }
            }
        }
    }
}


