package com.example.chicago.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.chicago.R
import com.example.chicago.ui.layout.AppDefaultLayout
import com.example.chicago.ui.layout.AppExpandedLayout
import com.example.chicago.ui.screens.ChicagoScreens
import com.example.chicago.ui.viewmodel.ChicagoViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar(
    backStackEntry: NavBackStackEntry?,
    categoryTitle: Int,
    onBackPress: () -> Unit,
    modifier: Modifier = Modifier
) {
    val currentScreen = ChicagoScreens.valueOf(
        backStackEntry?.destination?.route ?: ChicagoScreens.Home.name
    )
    TopAppBar(
        title = {
            Text(
                text = if (currentScreen == ChicagoScreens.Recommendation) {
                    stringResource(id = categoryTitle)
                } else {
                    stringResource(id = currentScreen.title)
                }
            )
        },
        navigationIcon = {
            if (currentScreen != ChicagoScreens.Home) {
                IconButton(
                    onClick = onBackPress
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Default.ArrowBack,
                        contentDescription = stringResource(id = R.string.back)
                    )
                }
            }
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
    val backStackEntry by navController.currentBackStackEntryAsState()

    Scaffold(topBar = {
        AppTopBar(
            backStackEntry = backStackEntry,
            categoryTitle = uiState.currentCategory.title,
            onBackPress = {
                navController.navigateUp()
            }
        )
    }) { innerPadding ->

        when (windowSize) {
            WindowWidthSizeClass.Expanded -> AppExpandedLayout(
                uiState = uiState,
                viewModel = viewModel,
                innerPadding = innerPadding,
                navController = navController
            )

            else -> AppDefaultLayout(
                uiState = uiState,
                viewModel = viewModel,
                innerPadding = innerPadding,
                navController = navController
            )
        }

//        NavHost(
//            navController = navController,
//            startDestination = ChicagoScreens.Home.name,
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(innerPadding),
//        ) {
//            composable(route = ChicagoScreens.Home.name) {
//                HomeScreen(onCardClick = {
//                    viewModel.updateCategory(it)
//                    navController.navigate(ChicagoScreens.Recommendation.name)
//                })
//            }
//            composable(route = ChicagoScreens.Recommendation.name) {
//                RecomScreen(selectedCategory = uiState.currentCategory, onCardClick = {
//                    viewModel.updateUserSelected(it)
//                    navController.navigate(ChicagoScreens.Details.name)
//                })
//            }
//            composable(route = ChicagoScreens.Details.name) {
//                DetailScreen(details = uiState.userSelectedCurrent)
//            }
//        }
    }
}