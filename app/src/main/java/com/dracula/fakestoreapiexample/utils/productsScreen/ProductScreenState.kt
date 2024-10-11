package com.dracula.fakestoreapiexample.utils.productsScreen

import com.dracula.fakestoreapiexample.model.ProductResponse

data class ProductScreenState(
	val products: List<ProductResponse> = emptyList()
)