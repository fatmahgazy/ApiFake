package com.dracula.fakestoreapiexample.utils.categoryScreen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dracula.fakestoreapiexample.ResultStates.ResultWrapper
import com.dracula.fakestoreapiexample.ResultStates.UiText
import com.dracula.fakestoreapiexample.domain.ProductRepository
import com.dracula.fakestoreapiexample.utils.categoryScreen.CategoriesState
import kotlinx.coroutines.launch

class CategoriesViewModel: ViewModel() {
    private val repo = ProductRepository()

    private val _state = mutableStateOf(CategoriesState())
    var state: State<CategoriesState> = _state

    private val _errorMessage = mutableStateOf<UiText?>(null)
    var errorMessage: State<UiText?> = _errorMessage

    init {
        getCategories()
    }

    private fun getCategories() {
        viewModelScope.launch {
            val response = repo.getCategories()
           when(response){
               is ResultWrapper.Success -> _state.value = state.value.copy(
                   categoriesState = response.data
               )
               is ResultWrapper.Error -> _errorMessage.value = response.error
           }
        }
    }
}