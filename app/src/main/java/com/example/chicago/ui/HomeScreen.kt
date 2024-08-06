package com.example.chicago.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.chicago.data.DataSource
import com.example.chicago.models.Category
import com.example.chicago.ui.theme.ChicagoTheme


@Composable
fun CategoryCard(category: Category, modifier: Modifier = Modifier) {
    Card(modifier = modifier) {
        Box {
            Image(
                painter = painterResource(id = category.image),
                contentDescription = category.title.toString(),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(210.dp)
                    .alpha(0.8F),
                contentScale = ContentScale.Crop,
            )
            Text(
                text = stringResource(id = category.title),
                style = MaterialTheme.typography.displaySmall,
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}


@Preview
@Composable
fun CategoryCardPreview() {
    ChicagoTheme {
        val category1 = DataSource.categoryList[0]
        CategoryCard(category1)
    }
}