package com.dracula.fakestoreapiexample.domain

import android.util.Log
import androidx.activity.compose.ReportDrawnWhen
import com.dracula.fakestoreapiexample.ResultStates.ResultWrapper
import com.dracula.fakestoreapiexample.ResultStates.UiText
import com.dracula.fakestoreapiexample.api.RetrofitInstance
import com.dracula.fakestoreapiexample.model.ProductResponse
import java.net.SocketTimeoutException
import java.net.UnknownHostException

class ProductRepository {
	// TODO: Initialize the Retrofit API instance
	private val api = RetrofitInstance.api
	// TODO: Create a suspend function to fetch products from the API
	suspend fun getProducts(): ResultWrapper<List<ProductResponse>>? {
		// TODO: Make the API call to get products
		return try {
			val response = api.getProducts()
			ResultWrapper.Success(response)
		}
		catch (e: Exception){
			when(e){
				is UnknownHostException -> {
					ResultWrapper.Error(Exception(""))
				}
				is SocketTimeoutException -> {
					Result.failure(Exception("Socket Timeout Exception"))
				}
				else -> {
					Result.failure(Exception(e))
				}
			}

		}
		}
	suspend fun getCategories(): Result<List<String>>{
		return try {
		    val responseCategories = api.getCategories()
			 Result.success(responseCategories)
		}catch (e: Exception){
			when(e){
				is UnknownHostException -> {
					Result.failure(Exception("UnknownException"))
				}
				is SocketTimeoutException -> {
					Result.failure(Exception("SocketTimeOutException"))
				}
				else -> {
					Result.failure(Exception(e))
				}
			}
		}
	}
	suspend fun getProductsForCategory(category: String): Result<List<ProductResponse>>{
		 return try {
			val response =  api.getProductsForCategory(category)
				 Result.success(response)
		 } catch (e: Exception) {
			 when(e) {
				 is UnknownHostException -> {
					 Result.failure(Exception("UnknownException"))
				 }

				 is SocketTimeoutException -> {
					 Result.failure(Exception("SocketTimOutException"))
				 }

				 else -> {
					 Result.failure(Exception(e))

				 }
			 }
		 }
	}
	suspend fun getSortedItems(sort: String): Result<List<ProductResponse>>{
		return try {
		    val response = api.getSortedItems(sort)
			Result.success(response)
		}catch (t: Throwable){
			when(t){
				is UnknownHostException -> {
					Result.failure(Exception("UnKnownException"))
				}
				is SocketTimeoutException ->{
					Result.failure(Exception("SocketTimOutException"))
				}
				else -> {
					Result.failure(Exception(t))
				}
			}
		}
	}
	suspend fun getLimitedProducts(limit: Int): Result<List<ProductResponse>>{
		return try {
			val response = api.getLimitedProducts(limit)
			Result.success(response)
		}catch (t: Throwable){
			when(t){
				is UnknownHostException ->{
					Result.failure(Exception("UnknownException"))
				}
				is SocketTimeoutException -> {
					Result.failure(Exception("SocketTimeOutException"))
				}
				else -> {
					Result.failure(Exception(t))
				}
			}

			}
		}

	}
