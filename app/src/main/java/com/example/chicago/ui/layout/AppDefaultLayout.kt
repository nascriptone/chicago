package com.example.chicago.ui.layout

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.chicago.ui.AppUIState
import com.example.chicago.ui.screens.ChicagoScreens
import com.example.chicago.ui.screens.DetailScreen
import com.example.chicago.ui.screens.HomeScreen
import com.example.chicago.ui.screens.RecomScreen
import com.example.chicago.ui.viewmodel.ChicagoViewModel

@Composable
fun AppDefaultLayout(
    uiState: AppUIState,
    viewModel: ChicagoViewModel,
    navController: NavHostController,
    windowSize: WindowWidthSizeClass,
    innerPadding: PaddingValues,
    modifier: Modifier = Modifier
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .fillMaxSize()
            .padding(innerPadding),
    ) {

        val suitableWidth = if (windowSize == WindowWidthSizeClass.Medium) 0.7F
        else 1F

        NavHost(
            navController = navController,
            startDestination = ChicagoScreens.Home.name,
            modifier = Modifier
                .fillMaxWidth(suitableWidth)
                .padding(horizontal = 4.dp)
        ) {
            composable(route = ChicagoScreens.Home.name) {
                HomeScreen(onCardClick = {
                    viewModel.updateCategory(it)
                    navController.navigate(ChicagoScreens.Recommendation.name)
                })
            }
            composable(route = ChicagoScreens.Recommendation.name) {
                RecomScreen(selectedCategory = uiState.currentCategory, onCardClick = {
                    viewModel.updateUserSelected(it)
                    navController.navigate(ChicagoScreens.Details.name)
                })
            }
            composable(route = ChicagoScreens.Details.name) {
                DetailScreen(details = uiState.userSelectedCurrent)
            }
        }
    }
}