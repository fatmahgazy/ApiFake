package com.dracula.fakestoreapiexample

import retrofit2.http.GET

interface ProductEndPoint {
	@GET("products")
	suspend fun getProducts(): List<ProductResponse>
}

