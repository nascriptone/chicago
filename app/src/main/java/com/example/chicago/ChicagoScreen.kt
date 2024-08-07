package com.example.chicago

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.chicago.ui.screens.DetailsScreen
import com.example.chicago.ui.screens.HomeScreen
import com.example.chicago.ui.screens.RecomScreen
import com.example.chicago.ui.theme.ChicagoTheme


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
    val navController = rememberNavController()
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
                .verticalScroll(rememberScrollState())
                .padding(innerPadding),
        ) {
            composable(route = ChicagoScreen.Home.name) {
                HomeScreen(
                    onClick = {
                        navController.navigate(ChicagoScreen.Recommendation.name)
                    }
                )
            }
            composable(route = ChicagoScreen.Recommendation.name) {
                RecomScreen(
                    onClick = {
                        navController.navigate(ChicagoScreen.Details.name)
                    }
                )
            }
            composable(route = ChicagoScreen.Details.name) {
                DetailsScreen()
            }
        }
    }
}

//@Preview
//@Composable
//fun ScreensPreview() {
//    ChicagoTheme {
//        Scaffold(
//            topBar = {
//                AppTopBar()
//            }
//        ) {
//            NavHost(
//                navController = rememberNavController(),
//                modifier = Modifier.padding(it),
//                startDestination = ChicagoScreen.Home.name
//            ) {
//                composable(route = ChicagoScreen.Home.name) {
//                    HomeScreen(onClick = { /*TODO*/ })
//                }
//            }
//        }
//    }
//}