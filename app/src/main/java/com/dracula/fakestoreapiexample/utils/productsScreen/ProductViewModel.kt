package com.dracula.fakestoreapiexample.utils.productsScreen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dracula.fakestoreapiexample.domain.ProductRepository
import kotlinx.coroutines.launch


class ProductViewModel : ViewModel() {
	// TODO: Initialize the product repository
    private val repo = ProductRepository()

	// TODO: Create a mutable state for the product screen state
    private val _state = mutableStateOf(ProductScreenState())
    var state : State<ProductScreenState> = _state

	// TODO: Initialize the ViewModel by calling the getProducts function
    init {
        getProducts()
    }

	// TODO: Create a function to fetch products from the repository and then update the state
    private fun getProducts(){
        viewModelScope.launch {
            val products = repo.getProducts()
            _state.value =state.value.copy(
                products = products
            )
        }
    }
    fun getProductsForCategory(category: String){
        viewModelScope.launch {
            val products = repo.getProductsForCategory(category)
            _state.value = state.value.copy(
                products = products
            )
        }
    }
   fun onEvent(event: ProductsEvent){
       viewModelScope.launch {
           when(event) {
               is ProductsEvent.Order -> {
                   val response = repo.getSortedItems(event.order)
                   _state.value = state.value.copy(
                    products = response
                   )
               }
           }
       }
   }

}