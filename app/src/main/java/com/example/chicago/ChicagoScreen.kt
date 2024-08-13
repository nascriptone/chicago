package com.example.chicago

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.chicago.ui.ChicagoViewModel
import com.example.chicago.ui.screens.DetailScreen
import com.example.chicago.ui.screens.HomeScreen
import com.example.chicago.ui.screens.RecomScreen


enum class ChicagoScreen {
    Home,
    Recommendation,
    Details
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar(modifier: Modifier = Modifier) {
    TopAppBar(
        title = {
            Text(text = "Chicago")
        },
        modifier
    )
}

@Composable
fun ChicagoApp() {

    val viewModel: ChicagoViewModel = viewModel()
    val navController = rememberNavController()

    val uiState by viewModel.uiState.collectAsState()


    Scaffold(
        topBar = {
            AppTopBar()
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = ChicagoScreen.Home.name,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
        ) {
            composable(route = ChicagoScreen.Home.name) {
                HomeScreen(
                    onCardClick = {
                        viewModel.updateSelectedCategory(it)
                        navController.navigate(ChicagoScreen.Recommendation.name)
                    }
                )
            }
            composable(route = ChicagoScreen.Recommendation.name) {
                RecomScreen(
                    selectedCategory = uiState.selectedCategory,
                    onCardClick = {
                        navController.navigate(ChicagoScreen.Details.name)
                    }
                )
            }
            composable(route = ChicagoScreen.Details.name) {
                DetailScreen()
            }
        }
    }
}