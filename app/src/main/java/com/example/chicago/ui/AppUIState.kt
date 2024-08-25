package com.example.chicago.ui

import com.example.chicago.data.DataSource
import com.example.chicago.models.Category
import com.example.chicago.models.Recommend

data class AppUIState(
    val currentCategory: Category = DataSource.categoryList.first(),
    val userSelectedCurrent: Recommend = DataSource.categoryList.first().recommendations.first(),
)
