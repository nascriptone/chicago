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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.chicago.data.DataSource
import com.example.chicago.models.Recommend
import com.example.chicago.ui.theme.ChicagoTheme

@Composable
fun RecomScreen(
    selectedCategory: Int,
    onCardClick: () -> Unit,
    modifier: Modifier = Modifier
) {

    val listToShow: List<Recommend> = recommendedList(selectedCategory)

    LazyColumn(modifier = modifier.padding(horizontal = 8.dp)) {
        items(listToShow) { item ->
            RecomCard(
                recommend = item,
                onCardClick,
                modifier = Modifier.padding(8.dp)
            )
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
        modifier = modifier
    ) {
        Column(
            modifier = Modifier.padding(12.dp)
        ) {
            Image(
                painter = painterResource(id = recommend.image),
                contentDescription = stringResource(
                    id = recommend.name
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = stringResource(id = recommend.name),
                style = MaterialTheme.typography.titleLarge
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(top = 4.dp)
            ) {
                Icon(imageVector = Icons.Default.LocationOn, contentDescription = null)
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = stringResource(id = recommend.place),
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}

fun recommendedList(selectedCategory: Int): List<Recommend> {
    return DataSource.listOfRecommendations.first {
        it.listBy == selectedCategory
    }.list
}

@Preview
@Composable
fun RecomCardPreview() {
    val recom = DataSource.listOfRecommendations.first().list
    ChicagoTheme {
        RecomCard(recommend = recom[4], onCardClick = {})
    }
}
