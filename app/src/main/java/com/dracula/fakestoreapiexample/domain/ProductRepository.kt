package com.dracula.fakestoreapiexample.domain

import android.util.Log
import com.dracula.fakestoreapiexample.api.RetrofitInstance
import com.dracula.fakestoreapiexample.model.ProductResponse

class ProductRepository {
	// TODO: Initialize the Retrofit API instance
	private val api = RetrofitInstance.api
	// TODO: Create a suspend function to fetch products from the API
	suspend fun getProducts(): List<ProductResponse> {
		// TODO: Make the API call to get products
		return try {
			val response = api.getProducts()
			// TODO: Return the response
			response
		}
		catch (e: Exception){
			Log.d("ProductRepository","the error message is : ${e.message} ")
			emptyList()
		}
		}
	suspend fun getCategories(): List<String>{
		return try {
		    val responseCategories = api.getCategories()
			return responseCategories
		}catch (e: Exception){
			emptyList()
		}
	}
	suspend fun getProductsForCategory(category: String): List<ProductResponse>{
		 return try {
			 return api.getProductsForCategory(category)
		 } catch (e: Exception) {
			 emptyList()
		 }
	}
	suspend fun getSortedItems(sort: String): List<ProductResponse>{
		return try {
		    val response = api.getSortedItems(sort)
			response
		}catch (t: Throwable){
			emptyList()
		}
	}
	suspend fun getLimitedProducts(limit: Int): List<ProductResponse>{
		return try {
			val response = api.getLimitedProducts(limit)
			response
		}catch (t: Throwable){
			emptyList()
		}

	}



}