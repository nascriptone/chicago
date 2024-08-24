package com.example.chicago.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.chicago.ui.screens.ChicagoScreens
import com.example.chicago.ui.screens.DetailScreen
import com.example.chicago.ui.screens.HomeScreen
import com.example.chicago.ui.screens.RecomScreen
import com.example.chicago.utils.AppContentType

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar(modifier: Modifier = Modifier) {
    TopAppBar(
        title = {
            Text(text = "Chicago")
        },
        modifier = modifier
    )
}

@Composable
fun ChicagoApp(
    viewModel: ChicagoViewModel = viewModel(),
    navController: NavHostController = rememberNavController(),
    windowSize: WindowWidthSizeClass,
) {
    val uiState by viewModel.uiState.collectAsState()
    val contentType = when (windowSize) {
        WindowWidthSizeClass.Expanded -> AppContentType.ListAndDetails
        else -> AppContentType.ListOnly
    }
    Scaffold(
        topBar = {
            AppTopBar()
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = ChicagoScreens.Home.name,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
        ) {
            composable(route = ChicagoScreens.Home.name) {
                HomeScreen(
                    onCardClick = {
                        viewModel.updateCategory(it)
                        navController.navigate(ChicagoScreens.Recommendation.name)
                    }
                )
            }
            composable(route = ChicagoScreens.Recommendation.name) {
                RecomScreen(
                    selectedCategory = uiState.currentCategory,
                    onCardClick = {
                        viewModel.updateUserSelected(it)
                        navController.navigate(ChicagoScreens.Details.name)
                    }
                )
            }
            composable(route = ChicagoScreens.Details.name) {
                DetailScreen(details = uiState.userSelectedCurrent)
            }
        }
    }
}