package com.example.chicago.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowHeightSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.chicago.data.DataSource
import com.example.chicago.models.Category
import com.example.chicago.models.Recommend
import com.example.chicago.ui.AppUIState
import com.example.chicago.ui.layout.HomeScreenExpanded
import com.example.chicago.ui.theme.ChicagoTheme
import com.example.chicago.ui.viewmodel.ChicagoViewModel

@Composable
fun HomeScreen(
    data: List<Category>,
    viewModel: ChicagoViewModel,
    uiState: AppUIState,
    onCardClick: (Category) -> Unit,
    onRecomCardClick: (Recommend) -> Unit,
    windowWidthSizeClass: WindowWidthSizeClass,
    windowHeightSizeClass: WindowHeightSizeClass,
    modifier: Modifier = Modifier,
) {

    if (windowWidthSizeClass == WindowWidthSizeClass.Expanded) {
        HomeScreenExpanded(
            data = data,
            selectedCategory = uiState.currentCategory,
            windowWidthSizeClass = windowWidthSizeClass,
            windowHeightSizeClass = windowHeightSizeClass,
            onHomeCardClick = {
                viewModel.updateCategory(it)
            },
            onRecomCardClick = {
                onRecomCardClick(it)
            }
        )
    } else {
        HomeScreenContent(
            data = data,
            onCardClick = onCardClick,
            windowWidthSizeClass = windowWidthSizeClass,
            windowHeightSizeClass = windowHeightSizeClass,
            modifier = modifier
        )
    }
}

@Composable
fun HomeScreenContent(
    data: List<Category>,
    onCardClick: (Category) -> Unit,
    windowWidthSizeClass: WindowWidthSizeClass,
    windowHeightSizeClass: WindowHeightSizeClass,
    modifier: Modifier = Modifier
) {

    val cardSuitableHeight: Dp =
        if (
            windowWidthSizeClass == WindowWidthSizeClass.Expanded &&
            windowHeightSizeClass != WindowHeightSizeClass.Compact
        ) 320.dp
        else 260.dp
    LazyColumn(modifier = modifier) {

        item {
            Spacer(modifier = Modifier.height(16.dp))
        }

        items(data) { category ->
            CategoryCard(
                category = category,
                onCardClick = { onCardClick(category) },
                cardSuitableHeight = cardSuitableHeight,
                modifier = Modifier.padding(8.dp)
            )
        }

        item {
            Spacer(modifier = Modifier.height(80.dp))
        }
    }
}


@Composable
fun CategoryCard(
    category: Category,
    onCardClick: () -> Unit,
    modifier: Modifier = Modifier,
    cardSuitableHeight: Dp = 260.dp
) {
    Card(
        onClick = onCardClick,
        shape = MaterialTheme.shapes.extraLarge,
        modifier = modifier
    ) {
        Box {
            Image(
                painter = painterResource(id = category.image),
                contentDescription = category.title.toString(),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(cardSuitableHeight),
                contentScale = ContentScale.Crop,
            )
            Text(
                text = stringResource(id = category.title),
                color = Color.White,
                style = MaterialTheme.typography.displayMedium,
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}


@Preview
@Composable
fun CategoryCardPreview() {
    ChicagoTheme {
        val category1 = DataSource.categoryList[3]
        CategoryCard(category1, onCardClick = {})
    }
}