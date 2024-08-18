package com.example.chicago.models

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Category(
    @DrawableRes val image: Int,
    @StringRes val title: Int,
    val recommendations: List<Recommend>
)
