package com.example.chicago.ui

import com.example.chicago.models.Category
import com.example.chicago.models.Recommend

data class AppUIState(
    val currentCategory: Category,
    val userSelectedCurrent: Recommend
)
