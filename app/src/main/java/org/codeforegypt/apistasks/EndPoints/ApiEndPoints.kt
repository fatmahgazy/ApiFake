package org.codeforegypt.apistasks.EndPoints

import org.codeforegypt.apistasks.ProductsScreen
import org.codeforegypt.apistasks.model.ProductResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiEndPoints {
    @GET("products")
    suspend fun getProducts(): List<ProductResponse>
    @GET("products/categories")
    suspend fun getAllCategory(): List<String>
    @GET("products/category/{category}")
    suspend fun getProductsFromCategories(
        @Path("category") category: String
    ):List<ProductResponse>

}