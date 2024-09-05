package com.example.chicago.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.chicago.R
import com.example.chicago.data.DataSource
import com.example.chicago.models.Category
import com.example.chicago.models.Recommend
import com.example.chicago.ui.screens.ChicagoScreens
import com.example.chicago.ui.screens.DetailScreen
import com.example.chicago.ui.screens.HomeScreen
import com.example.chicago.ui.screens.RecomScreen
import com.example.chicago.ui.viewmodel.ChicagoViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar(
    windowSize: WindowWidthSizeClass,
    currentScreen: ChicagoScreens,
    categoryTitle: Int,
    onBackPress: () -> Unit,
    modifier: Modifier = Modifier
) {

    TopAppBar(title = {
        val title = if (currentScreen == ChicagoScreens.Recommendation) {
            if (windowSize != WindowWidthSizeClass.Expanded) {
                stringResource(id = categoryTitle)
            } else {
                stringResource(id = ChicagoScreens.Home.title)
            }
        } else {
            stringResource(id = currentScreen.title)
        }
        Text(
            text = title
        )
    }, navigationIcon = {
        val ableToShow: Boolean =
            windowSize != WindowWidthSizeClass.Expanded || currentScreen != ChicagoScreens.Recommendation
        if (currentScreen != ChicagoScreens.Home && ableToShow) {
            IconButton(
                onClick = onBackPress
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Default.ArrowBack,
                    contentDescription = stringResource(id = R.string.back)
                )
            }
        }
    }, modifier = modifier
    )
}

@Composable
fun ChicagoApp(
    viewModel: ChicagoViewModel = viewModel(),
    navController: NavHostController = rememberNavController(),
    windowSize: WindowWidthSizeClass,
) {

    val data: List<Category> = DataSource.categoryList
    val uiState by viewModel.uiState.collectAsState()
    val backStackEntry by navController.currentBackStackEntryAsState()

    val currentScreen = ChicagoScreens.valueOf(
        backStackEntry?.destination?.route ?: ChicagoScreens.Home.name
    )

    val previousScreen = ChicagoScreens.valueOf(
        navController.previousBackStackEntry?.destination?.route ?: ChicagoScreens.Home.name
    )


    Scaffold(topBar = {
        AppTopBar(windowSize = windowSize,
            currentScreen = currentScreen,
            categoryTitle = uiState.currentCategory.title,
            onBackPress = {

                if (previousScreen == ChicagoScreens.Home && currentScreen == ChicagoScreens.Details) {
                    navController.navigate(
                        ChicagoScreens.Recommendation.name
                    ) {
                        popUpTo(
                            currentScreen.name
                        ) {
                            inclusive = true
                        }
                    }
                } else {
                    navController.navigateUp()
                }
            })
    }) { innerPadding ->

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
        ) {

            val suitableWidth = if (windowSize == WindowWidthSizeClass.Medium) 0.7F
            else 1F

            fun goToDetailsScreen(data: Recommend) {
                viewModel.updateUserSelected(data)
                navController.navigate(ChicagoScreens.Details.name)
            }

            NavHost(
                navController = navController,
                startDestination = ChicagoScreens.Home.name,
                modifier = Modifier
                    .fillMaxWidth(suitableWidth)
                    .padding(horizontal = 4.dp)
            ) {
                composable(route = ChicagoScreens.Home.name) {
                    HomeScreen(
                        data = data,
                        windowWidthSizeClass = windowSize,
                        viewModel = viewModel,
                        uiState = uiState,
                        onCardClick = {
                            viewModel.updateCategory(it)
                            navController.navigate(ChicagoScreens.Recommendation.name)
                        },
                        onRecomCardClick = {
                            goToDetailsScreen(it)
                        }
                    )
                }
                composable(route = ChicagoScreens.Recommendation.name) {
                    RecomScreen(
                        data = data,
                        selectedCategory = uiState.currentCategory,
                        windowWidthSizeClass = windowSize,
                        viewModel = viewModel,
                        uiState = uiState,
                        onCardClick = {
                            goToDetailsScreen(it)
                        }

                    )
                }
                composable(route = ChicagoScreens.Details.name) {
                    DetailScreen(
                        details = uiState.userSelectedCurrent,
                        windowWidthSizeClass = windowSize
                    )
                }
            }
        }
    }
}