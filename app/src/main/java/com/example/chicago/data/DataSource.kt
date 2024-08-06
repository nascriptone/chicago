package com.example.chicago.data

import com.example.chicago.R
import com.example.chicago.models.Category

object DataSource {
    val categoryList: List<Category> = listOf(
        Category(
            image = R.drawable.museum_banner,
            title = R.string.museums
        ),
        Category(
            image = R.drawable.park_banner,
            title = R.string.parks
        ),
        Category(
            image = R.drawable.theatre_banner,
            title = R.string.theatres
        ),
        Category(
            image = R.drawable.reataurant_banner,
            title = R.string.restaurants
        ),
        Category(
            image = R.drawable.shopping_banner,
            title = R.string.shopping_centres
        ),
        Category(
            image = R.drawable.historicalsite_banner,
            title = R.string.historical_sites
        )
    )
}