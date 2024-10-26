package com.dracula.fakestoreapiexample.utils.productsScreen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dracula.fakestoreapiexample.ResultStates.ResultWrapper
import com.dracula.fakestoreapiexample.ResultStates.UiText
import com.dracula.fakestoreapiexample.domain.ProductRepository
import kotlinx.coroutines.launch


class ProductViewModel : ViewModel() {
	// TODO: Initialize the product repository
    private val repo = ProductRepository()

	// TODO: Create a mutable state for the product screen state
    private val _state = mutableStateOf(ProductScreenState())
    var state : State<ProductScreenState> = _state

    private val _errorMessage = mutableStateOf<UiText?>(null)
    var errorState: State<UiText?> = _errorMessage

	// TODO: Initialize the ViewModel by calling the getProducts function
    init {
        getProducts()
    }

	// TODO: Create a function to fetch products from the repository and then update the state
    private fun getProducts(){
        viewModelScope.launch {
            val products = repo.getProducts()
            when(products){
                is ResultWrapper.Error ->  _errorMessage.value = products.error
                is ResultWrapper.Success -> _state.value =state.value.copy(
                    products = products.data
                )
            }
        }
    }
    fun getProductsForCategory(category: String){
        viewModelScope.launch {
            val products = repo.getProductsForCategory(category)
            when(products) {
                is ResultWrapper.Success -> _state.value = state.value.copy(
                    products = products.data
                )
                is ResultWrapper.Error ->
                    _errorMessage.value = products.error
            }
        }
    }
   fun onEvent(event: ProductsEvent){
       viewModelScope.launch {
           when(event) {
               is ProductsEvent.Order -> {
                   val response = repo.getSortedItems(event.order)
                 when(response){
                      is ResultWrapper.Success -> _state.value = state.value.copy(
                         products = response.data
                     )
                     is ResultWrapper.Error -> _errorMessage.value = response.error
                 }
               }

               is ProductsEvent.LimitProducts -> {
                   val limitedResponse = repo.getLimitedProducts(event.limit)
                   when(limitedResponse){
                       is ResultWrapper.Success -> _state.value = state.value.copy(
                           products = limitedResponse.data
                       )
                       is ResultWrapper.Error -> _errorMessage.value = limitedResponse.error
                   }
               }
           }
       }
   }

}