package com.example.chicago.models

import androidx.annotation.StringRes

data class RecommendedList(
    @StringRes val listBy: Int,
    val list: List<Recommend>
)
