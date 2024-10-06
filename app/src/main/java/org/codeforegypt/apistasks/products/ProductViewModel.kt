package org.codeforegypt.apistasks.products

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.codeforegypt.apistasks.domain.Repositry

class ProductViewModel: ViewModel(){
    private val repo = Repositry()

    private val _state = mutableStateOf(ProductsState())
    var state: State<ProductsState> = _state

    init {
        getProducts()
    }

   private fun getProducts(){
        viewModelScope.launch {
            val response = repo.getProducts()
            _state.value = state.value.copy(
                products = response
            )

        }

    }
    fun getProductsFormCategories(category: String){
        viewModelScope.launch {
            val response = repo.getProductsFromCategories(category)
            _state.value = state.value.copy(
                products = response
            )
        }

    }


}