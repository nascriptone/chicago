package com.example.chicago.ui

import androidx.lifecycle.ViewModel
import com.example.chicago.data.DataSource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class ChicagoViewModel() : ViewModel() {

    private val _uiState = MutableStateFlow(AppUIState(
        selectedCategory = DataSource.categoryList.first().title
    ))
    val uiState: StateFlow<AppUIState> = _uiState.asStateFlow()


    fun updateSelectedCategory(title: Int) {
        _uiState.update {
            it.copy(
                selectedCategory = title
            )
        }
    }

}