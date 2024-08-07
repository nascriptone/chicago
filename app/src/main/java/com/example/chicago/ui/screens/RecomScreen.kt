package com.example.chicago.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun RecomScreen(onClick: () -> Unit, modifier: Modifier = Modifier) {
    Column(modifier) {
        Text(text = "This is Recommendation Screen")
        OutlinedButton(onClick = onClick) {
            Text(text = "Show the details")
        }
    }
}