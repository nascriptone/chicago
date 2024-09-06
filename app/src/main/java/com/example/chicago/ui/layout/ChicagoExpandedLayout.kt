package com.example.chicago.ui.layout

import android.app.Activity
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.windowsizeclass.WindowHeightSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.chicago.data.DataSource
import com.example.chicago.models.Category
import com.example.chicago.models.Recommend
import com.example.chicago.ui.screens.DetailsScreenImageContent
import com.example.chicago.ui.screens.DetailsScreenMainDetails
import com.example.chicago.ui.screens.HomeScreenContent
import com.example.chicago.ui.screens.RecomScreenContent
import com.example.chicago.ui.theme.ChicagoTheme

@Composable
fun HomeScreenExpanded(
    data: List<Category>,
    selectedCategory: Category,
    windowWidthSizeClass: WindowWidthSizeClass,
    windowHeightSizeClass: WindowHeightSizeClass,
    modifier: Modifier = Modifier,
    onHomeCardClick: (Category) -> Unit = {},
    onRecomCardClick: (Recommend) -> Unit = {}
) {

    // To Exit from the app when user click the back button.
    val activity = (LocalContext.current as? Activity)
    BackHandler {
        activity?.finish()
    }

    Row(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .weight(1F)
        ) {
            HomeScreenContent(
                data = data,
                onCardClick = onHomeCardClick,
                windowWidthSizeClass = windowWidthSizeClass,
                windowHeightSizeClass = windowHeightSizeClass
            )
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .weight(1F)
        ) {
            RecomScreenContent(
                selectedCategory = selectedCategory,
                onCardClick = onRecomCardClick
            )
        }
    }
}

@Composable
fun DetailsScreenExpanded(
    details: Recommend,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ) {


        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 12.dp)
                .weight(6F)
        ) {
            Spacer(modifier = Modifier.height(20.dp))
            DetailsScreenImageContent(
                details,
                modifier = Modifier.fillMaxHeight(0.65F)
            )
        }


        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 12.dp)
                .weight(5F)
        ) {
            Spacer(modifier = Modifier.height(20.dp))
            DetailsScreenMainDetails(details)
        }
    }
}

//@Preview
//@Composable
//fun HomeScreenExpandedPreview() {
//    ChicagoTheme {
//        val data = DataSource.categoryList
//        HomeScreenExpanded(
//            data = data,
//            selectedCategory = data.first()
//        )
//    }
//}

@Preview
@Composable
fun DetailsScreenExpandedPreview() {
    ChicagoTheme {
        DetailsScreenExpanded(
            details = DataSource.categoryList[4].recommendations[4]
        )
    }
}