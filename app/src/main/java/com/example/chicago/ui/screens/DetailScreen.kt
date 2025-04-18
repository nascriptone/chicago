package com.example.chicago.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.chicago.R
import com.example.chicago.models.Recommend
import com.example.chicago.ui.layout.DetailsScreenExpanded

@Composable
fun DetailScreen(
    details: Recommend,
    windowWidthSizeClass: WindowWidthSizeClass,
    modifier: Modifier = Modifier
) {

    if (windowWidthSizeClass == WindowWidthSizeClass.Expanded) {
        DetailsScreenExpanded(
            details = details,
            modifier = modifier
        )
    } else {
        DetailsScreenContent(
            details = details,
            modifier = modifier
        )
    }

}

@Composable
fun DetailsScreenContent(
    details: Recommend,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 8.dp), horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(12.dp))
        DetailsScreenImageContent(details)
        Spacer(modifier = Modifier.height(20.dp))
        DetailsScreenMainDetails(details)
    }
}

@Composable
fun DetailsScreenImageContent(
    details: Recommend,
    modifier: Modifier = Modifier
) {
    val painter = painterResource(id = details.image)
    Image(
        painter = painter,
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(28.dp)),
        contentScale = ContentScale.Crop,
        contentDescription = stringResource(id = details.name)
    )
}

@Composable
fun DetailsScreenMainDetails(
    details: Recommend,
    modifier: Modifier = Modifier
) {
    Surface(
        color = MaterialTheme.colorScheme.surfaceContainer, shape = RoundedCornerShape(28.dp),
        modifier = modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = stringResource(id = details.name),
                style = MaterialTheme.typography.titleLarge
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = stringResource(id = details.description),
                style = MaterialTheme.typography.bodyLarge,
            )
        }
    }
    Spacer(modifier = Modifier.height(20.dp))
    Surface(
        color = MaterialTheme.colorScheme.surfaceContainer, shape = RoundedCornerShape(28.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.LocationOn,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.secondary
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = stringResource(id = details.place),
                    style = MaterialTheme.typography.bodyMedium
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                if (details.open != null) {
                    val open = stringResource(id = R.string.open)
                    val openTime = stringResource(id = details.open)
                    Text(text = "$open $openTime")
                }
                if (details.close != null) {
                    val close = stringResource(id = R.string.close)
                    val closeTime = stringResource(id = details.close)
                    Text(text = "$close $closeTime")
                }
            }
        }
    }
    Spacer(modifier = Modifier.height(40.dp))
}


//@Preview
//@Composable
//fun DetailsScreenPreview() {
//    ChicagoTheme(darkTheme = true) {
//        DetailScreen(
//            details = DataSource.categoryList[4].recommendations[3]
//        )
//    }
//}