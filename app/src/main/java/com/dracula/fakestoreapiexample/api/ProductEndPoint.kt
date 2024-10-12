package com.dracula.fakestoreapiexample.api

import com.dracula.fakestoreapiexample.model.ProductResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ProductEndPoint {
	@GET("products")
	suspend fun getProducts(): List<ProductResponse>
	@GET("products/categories")
	suspend fun getCategories(): List<String>
	@GET("products/category/{category}")
	suspend fun getProductsForCategory(
		@Path("category") category: String
	): List<ProductResponse>
	@GET("products")
	suspend fun getSortedItems(
		@Query("sort") sort: String
	): List<ProductResponse>
	@GET("products")
	suspend fun getLimitedProducts(
		@Query("limit") limit: Int
	):List<ProductResponse>
}

