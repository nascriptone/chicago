package com.example.chicago.ui.layout

import android.app.Activity
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext

@Composable
fun HomeScreenExpanded(
    onButtonClick: () -> Unit,
    modifier: Modifier = Modifier
) {

    // To Exit from the app when user click the back button.
    val activity = (LocalContext.current as? Activity)
    BackHandler {
        activity?.finish()
    }


    Row(
        modifier = modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.primaryContainer)
    ) {
        Column(
            modifier = Modifier.weight(1F)
        ) {
            Text(text = "This is the Pane for HomeScreen contents")
        }
        Column(
            modifier = Modifier
                .weight(1F)
                .background(MaterialTheme.colorScheme.onPrimaryContainer)
        ) {
            Text(text = "This is the pane for recom contents")
            Button(onClick = onButtonClick) {
                Text(text = "Check Details")
            }
        }
    }
}

@Composable
fun DetailsScreenExpanded(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.secondaryContainer)
    ) {
        Box(
            modifier = Modifier.background(MaterialTheme.colorScheme.onSecondaryContainer)
        ) {
            Text(text = "This is the pane for the Image")
        }
        Column {
            Text(text = "This is the column for details")
        }
    }
}