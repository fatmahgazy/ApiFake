package com.dracula.fakestoreapiexample

data class ProductScreenState(
	val products: List<ProductResponse> = emptyList()
)