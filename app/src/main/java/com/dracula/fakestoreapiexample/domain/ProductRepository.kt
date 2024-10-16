package com.dracula.fakestoreapiexample.domain

import android.util.Log
import androidx.activity.compose.ReportDrawnWhen
import com.dracula.fakestoreapiexample.api.RetrofitInstance
import com.dracula.fakestoreapiexample.model.ProductResponse

class ProductRepository {
	// TODO: Initialize the Retrofit API instance
	private val api = RetrofitInstance.api
	// TODO: Create a suspend function to fetch products from the API
	suspend fun getProducts(): Result<List<ProductResponse>> {
		// TODO: Make the API call to get products
		return try {
			val response = api.getProducts()
			Result.success(response)
		}
		catch (e: Exception){
			Result.failure(e)
		}
		}
	suspend fun getCategories(): Result<List<String>>{
		return try {
		    val responseCategories = api.getCategories()
			 Result.success(responseCategories)
		}catch (e: Exception){
			Result.failure(e)
		}
	}
	suspend fun getProductsForCategory(category: String): Result<List<ProductResponse>>{
		 return try {
			val response =  api.getProductsForCategory(category)
				 Result.success(response)
		 } catch (e: Exception) {
			Result.failure(e)
		 }
	}
	suspend fun getSortedItems(sort: String): Result<List<ProductResponse>>{
		return try {
		    val response = api.getSortedItems(sort)
			Result.success(response)
		}catch (t: Throwable){
			Result.failure(t)
		}
	}
	suspend fun getLimitedProducts(limit: Int): Result<List<ProductResponse>>{
		return try {
			val response = api.getLimitedProducts(limit)
			Result.success(response)
		}catch (t: Throwable){
			Result.failure(t)
			}
		}

	}
