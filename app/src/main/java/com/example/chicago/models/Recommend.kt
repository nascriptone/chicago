package com.example.chicago.models

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Recommend(
    @DrawableRes val image: Int,
    @StringRes val name: Int,
    @StringRes val description: Int,
    @StringRes val place: Int,
    @StringRes val open: Int?,
    @StringRes val close: Int?
)
