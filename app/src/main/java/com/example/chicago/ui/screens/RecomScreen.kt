package com.example.chicago.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.chicago.data.DataSource
import com.example.chicago.models.Category
import com.example.chicago.models.Recommend
import com.example.chicago.ui.AppUIState
import com.example.chicago.ui.layout.HomeScreenExpanded
import com.example.chicago.ui.theme.ChicagoTheme
import com.example.chicago.ui.viewmodel.ChicagoViewModel

@Composable
fun RecomScreen(
    data: List<Category>,
    selectedCategory: Category,
    onCardClick: (Recommend) -> Unit,
    viewModel: ChicagoViewModel,
    uiState: AppUIState,
    windowWidthSizeClass: WindowWidthSizeClass,
    modifier: Modifier = Modifier
) {

    if (windowWidthSizeClass == WindowWidthSizeClass.Expanded) {
        HomeScreenExpanded(
            data = data,
            selectedCategory = uiState.currentCategory,
            onHomeCardClick = {
                viewModel.updateCategory(it)
            },
            onRecomCardClick = onCardClick
        )
    } else {
        RecomScreenContent(
            selectedCategory = selectedCategory,
            onCardClick = onCardClick,
            modifier = modifier
        )
    }

}

@Composable
fun RecomScreenContent(
    selectedCategory: Category,
    onCardClick: (Recommend) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier = modifier) {

        item {
            Spacer(modifier = Modifier.height(16.dp))
        }

        items(selectedCategory.recommendations) { item ->
            RecomCard(
                recommend = item,
                onCardClick = { onCardClick(item) },
                modifier = Modifier.padding(8.dp)
            )
        }

        item {
            Spacer(modifier = Modifier.height(80.dp))
        }
    }
}

@Composable
fun RecomCard(
    recommend: Recommend,
    onCardClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        onClick = onCardClick,
        modifier = modifier,
        shape = MaterialTheme.shapes.extraLarge
    ) {
        Image(
            painter = painterResource(id = recommend.image),
            contentDescription = stringResource(
                id = recommend.name
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier.padding(
                horizontal = 12.dp,
                vertical = 16.dp
            )
        ) {
            Text(
                text = stringResource(id = recommend.name),
                style = MaterialTheme.typography.titleLarge
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Icon(
                    tint = MaterialTheme.colorScheme.surfaceTint,
                    imageVector = Icons.Default.LocationOn,
                    contentDescription = null
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = stringResource(id = recommend.place),
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}


@Preview
@Composable
fun RecomCardPreview() {
    ChicagoTheme {
        RecomCard(recommend = DataSource.categoryList[5].recommendations[3], onCardClick = {})
    }
}
