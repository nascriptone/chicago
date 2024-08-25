package com.example.chicago.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.chicago.models.Category
import com.example.chicago.models.Recommend
import com.example.chicago.ui.AppUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class ChicagoViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(AppUIState())
    val uiState: StateFlow<AppUIState> = _uiState.asStateFlow()


    fun updateCategory(category: Category) {
        _uiState.update {
            it.copy(
                currentCategory = category,
                userSelectedCurrent = category.recommendations.first(),
            )
        }
    }

    fun updateUserSelected(recommendation: Recommend) {
        _uiState.update {
            it.copy(
                userSelectedCurrent = recommendation
            )
        }
    }
}