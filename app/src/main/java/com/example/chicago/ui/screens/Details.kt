package com.example.chicago.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun DetailsScreen(modifier: Modifier = Modifier) {
    Column(modifier) {
        Text(text = "This is Details Screen")
    }
}