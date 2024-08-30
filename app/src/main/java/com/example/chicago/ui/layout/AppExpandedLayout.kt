package com.example.chicago.ui.layout

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import com.example.chicago.R
import com.example.chicago.ui.AppUIState
import com.example.chicago.ui.screens.DetailScreen
import com.example.chicago.ui.screens.HomeScreen
import com.example.chicago.ui.screens.RecomScreen
import com.example.chicago.ui.viewmodel.ChicagoViewModel

@Composable
fun AppExpandedLayout(
    uiState: AppUIState,
    viewModel: ChicagoViewModel,
    navController: NavHostController,
    innerPadding: PaddingValues,
    modifier: Modifier = Modifier
) {

    var isUserSelected by rememberSaveable { mutableStateOf(false) }

    Row(
        modifier = modifier
            .fillMaxSize()
            .padding(innerPadding)
    ) {
        HomeScreen(
            onCardClick = {
                viewModel.updateCategory(it)
                isUserSelected = false
            },
            modifier = Modifier.weight(3f)
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .weight(4f)
        ) {
            if (!isUserSelected) {
                RecomScreen(
                    selectedCategory = uiState.currentCategory,
                    onCardClick = {
                        viewModel.updateUserSelected(it)
                        isUserSelected = true
                    },
                )
            } else {
                IconButton(
                    onClick = {
                        isUserSelected = false
                    }
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Default.ArrowBack,
                        contentDescription = stringResource(
                            id = R.string.back
                        )
                    )
                }
                DetailScreen(details = uiState.userSelectedCurrent)
            }
        }
    }
}