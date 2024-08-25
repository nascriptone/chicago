package com.example.chicago.ui.layout

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
    innerPadding: PaddingValues,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = ChicagoScreens.Home.name,
        modifier = modifier
            .fillMaxSize()
            .padding(innerPadding),
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