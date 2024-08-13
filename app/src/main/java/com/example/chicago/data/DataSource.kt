package com.example.chicago.data

import com.example.chicago.R
import com.example.chicago.models.Category
import com.example.chicago.models.Recommend
import com.example.chicago.models.RecommendedList

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

    val listOfRecommendations: List<RecommendedList> = listOf(
        RecommendedList(
            listBy = R.string.museums,
            list = listOf(
                Recommend(
                    image = R.drawable.museum1,
                    name = R.string.museum_name1,
                    description = R.string.museum_description1,
                    place = R.string.museum_place1,
                    open = R.string.museum_open1,
                    close = R.string.museum_close1
                ),
                Recommend(
                    image = R.drawable.museum2,
                    name = R.string.museum_name2,
                    description = R.string.museum_description2,
                    place = R.string.museum_place2,
                    open = R.string.museum_open2,
                    close = R.string.museum_close2
                ),
                Recommend(
                    image = R.drawable.museum3,
                    name = R.string.museum_name3,
                    description = R.string.museum_description3,
                    place = R.string.museum_place3,
                    open = R.string.museum_open3,
                    close = R.string.museum_close3
                ),
                Recommend(
                    image = R.drawable.museum4,
                    name = R.string.museum_name4,
                    description = R.string.museum_description4,
                    place = R.string.museum_place4,
                    open = R.string.museum_open4,
                    close = R.string.museum_close4
                ),
                Recommend(
                    image = R.drawable.museum5,
                    name = R.string.museum_name5,
                    description = R.string.museum_description5,
                    place = R.string.museum_place5,
                    open = R.string.museum_open5,
                    close = R.string.museum_close5
                )
            )
        ),
        RecommendedList(
            listBy = R.string.parks,
            list = listOf(
                Recommend(
                    image = R.drawable.park1,
                    name = R.string.park_name1,
                    description = R.string.park_description1,
                    place = R.string.park_place1,
                    open = R.string.park_open1,
                    close = R.string.park_close1
                ),
                Recommend(
                    image = R.drawable.park2,
                    name = R.string.park_name2,
                    description = R.string.park_description2,
                    place = R.string.park_place2,
                    open = R.string.park_open2,
                    close = R.string.park_close2
                ),
                Recommend(
                    image = R.drawable.park3,
                    name = R.string.park_name3,
                    description = R.string.park_description3,
                    place = R.string.park_place3,
                    open = R.string.park_open3,
                    close = R.string.park_close3
                ),
                Recommend(
                    image = R.drawable.park4,
                    name = R.string.park_name4,
                    description = R.string.park_description4,
                    place = R.string.park_place4,
                    open = R.string.park_open4,
                    close = R.string.park_close4
                ),
                Recommend(
                    image = R.drawable.park5,
                    name = R.string.park_name5,
                    description = R.string.park_description5,
                    place = R.string.park_place5,
                    open = R.string.park_open5,
                    close = R.string.park_close5
                )
            )
        ),
        RecommendedList(
            listBy = R.string.theatres,
            list = listOf(
                Recommend(
                    image = R.drawable.theatre1,
                    name = R.string.theatre_name1,
                    description = R.string.theatre_description1,
                    place = R.string.theatre_place1,
                    open = R.string.theatre_open1,
                    close = null
                ),
                Recommend(
                    image = R.drawable.theatre2,
                    name = R.string.theatre_name2,
                    description = R.string.theatre_description2,
                    place = R.string.theatre_place2,
                    open = R.string.theatre_open2,
                    close = null
                ),
                Recommend(
                    image = R.drawable.theatre3,
                    name = R.string.theatre_name3,
                    description = R.string.theatre_description3,
                    place = R.string.theatre_place3,
                    open = R.string.theatre_open3,
                    close = null
                ),
                Recommend(
                    image = R.drawable.theatre4,
                    name = R.string.theatre_name4,
                    description = R.string.theatre_description4,
                    place = R.string.theatre_place4,
                    open = R.string.theatre_open4,
                    close = null
                ),
                Recommend(
                    image = R.drawable.theatre5,
                    name = R.string.theatre_name5,
                    description = R.string.theatre_description5,
                    place = R.string.theatre_place5,
                    open = R.string.theatre_open5,
                    close = null
                )
            )
        ),
        RecommendedList(
            listBy = R.string.shopping_centres,
            list = listOf(
                Recommend(
                    image = R.drawable.shopping1,
                    name = R.string.shopping_centre_name1,
                    description = R.string.shopping_centre_description1,
                    place = R.string.shopping_centre_place1,
                    open = R.string.shopping_centre_open1,
                    close = R.string.shopping_centre_close1
                ),
                Recommend(
                    image = R.drawable.shopping2,
                    name = R.string.shopping_centre_name2,
                    description = R.string.shopping_centre_description2,
                    place = R.string.shopping_centre_place2,
                    open = R.string.shopping_centre_open2,
                    close = R.string.shopping_centre_close2
                ),
                Recommend(
                    image = R.drawable.shopping3,
                    name = R.string.shopping_centre_name3,
                    description = R.string.shopping_centre_description3,
                    place = R.string.shopping_centre_place3,
                    open = R.string.shopping_centre_open3,
                    close = R.string.shopping_centre_close3
                ),
                Recommend(
                    image = R.drawable.shopping4,
                    name = R.string.shopping_centre_name4,
                    description = R.string.shopping_centre_description4,
                    place = R.string.shopping_centre_place4,
                    open = R.string.shopping_centre_open4,
                    close = R.string.shopping_centre_close4
                ),
                Recommend(
                    image = R.drawable.shopping5,
                    name = R.string.shopping_centre_name5,
                    description = R.string.shopping_centre_description5,
                    place = R.string.shopping_centre_place5,
                    open = R.string.shopping_centre_open5,
                    close = R.string.shopping_centre_close5
                )
            )
        ),
        RecommendedList(
            listBy = R.string.restaurants,
            list = listOf(
                Recommend(
                    image = R.drawable.restaurant1,
                    name = R.string.restaurant_name1,
                    description = R.string.restaurant_description1,
                    place = R.string.restaurant_place1,
                    open = R.string.restaurant_open1,
                    close = R.string.restaurant_close1
                ),
                Recommend(
                    image = R.drawable.restaurant2,
                    name = R.string.restaurant_name2,
                    description = R.string.restaurant_description2,
                    place = R.string.restaurant_place2,
                    open = R.string.restaurant_open2,
                    close = R.string.restaurant_close2
                ),
                Recommend(
                    image = R.drawable.restaurant3,
                    name = R.string.restaurant_name3,
                    description = R.string.restaurant_description3,
                    place = R.string.restaurant_place3,
                    open = R.string.restaurant_open3,
                    close = R.string.restaurant_close3
                ),
                Recommend(
                    image = R.drawable.restaurant4,
                    name = R.string.restaurant_name4,
                    description = R.string.restaurant_description4,
                    place = R.string.restaurant_place4,
                    open = R.string.restaurant_open4,
                    close = R.string.restaurant_close4
                ),
                Recommend(
                    image = R.drawable.restaurant5,
                    name = R.string.restaurant_name5,
                    description = R.string.restaurant_description5,
                    place = R.string.restaurant_place5,
                    open = R.string.restaurant_open5,
                    close = R.string.restaurant_close5
                )
            )
        ),
        RecommendedList(
            listBy = R.string.historical_sites,
            list = listOf(
                Recommend(
                    image = R.drawable.historicalsite1,
                    name = R.string.historical_site_name1,
                    description = R.string.historical_site_description1,
                    place = R.string.historical_site_place1,
                    open = R.string.historical_site_open1,
                    close = R.string.historical_site_close1
                ),
                Recommend(
                    image = R.drawable.historicalsite2,
                    name = R.string.historical_site_name2,
                    description = R.string.historical_site_description2,
                    place = R.string.historical_site_place2,
                    open = R.string.historical_site_open2,
                    close = null
                ),
                Recommend(
                    image = R.drawable.historicalsite3,
                    name = R.string.historical_site_name3,
                    description = R.string.historical_site_description3,
                    place = R.string.historical_site_place3,
                    open = R.string.historical_site_open3,
                    close = R.string.historical_site_close3
                ),
                Recommend(
                    image = R.drawable.historicalsite4,
                    name = R.string.historical_site_name4,
                    description = R.string.historical_site_description4,
                    place = R.string.historical_site_place4,
                    open = R.string.historical_site_open4,
                    close = R.string.historical_site_close4
                ),
                Recommend(
                    image = R.drawable.historicalsite5,
                    name = R.string.historical_site_name5,
                    description = R.string.historical_site_description5,
                    place = R.string.historical_site_place5,
                    open = R.string.historical_site_open5,
                    close = R.string.historical_site_close5
                )
            )
        )
    )
}