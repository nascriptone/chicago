package com.example.chicago

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.chicago.ui.theme.ChicagoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ChicagoTheme {
                ChicagoApp()
            }
        }
    }
}

@Composable
fun ChicagoApp() {
    Scaffold(topBar = {
        AppTopBar()
    }) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            Card {
                Text(text = "Chicago")
            }

            IconButton(
                onClick = {},

                ) {
                Icon(imageVector = Icons.Default.Call, contentDescription = null)
            }

            Text(text = "This is another testing")

            Button(onClick = {}) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(imageVector = Icons.Default.Settings, contentDescription = null)
                    Spacer(modifier = Modifier.width(16.dp))
                    Text(text = "Settings")
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = "Chicago"
            )
        }, modifier = modifier
    )
}

@Preview
@Composable
fun HomeScreenPreview() {
    ChicagoTheme {
        Scaffold(topBar = {
            AppTopBar()
        }) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it)
            ) {
                Card {
                    Text(text = "Chicago")
                }

                IconButton(
                    onClick = {},

                    ) {
                    Icon(imageVector = Icons.Default.Call, contentDescription = null)
                }

                Text(text = "This is another testing")

                Button(onClick = {}) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(imageVector = Icons.Default.Settings, contentDescription = null)
                        Spacer(modifier = Modifier.width(18.dp))
                        Text(text = "Settings")
                    }
                }
            }
        }
    }
}
