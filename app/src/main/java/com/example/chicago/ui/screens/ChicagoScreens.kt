package com.example.chicago.ui.screens

import androidx.annotation.StringRes
import com.example.chicago.R

enum class ChicagoScreens(@StringRes val title: Int) {
    Home(title = R.string.home),
    Recommendation(title = R.string.recommendation),
    Details(title = R.string.details)
}