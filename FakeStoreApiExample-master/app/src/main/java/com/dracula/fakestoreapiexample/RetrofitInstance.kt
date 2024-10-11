package com.dracula.fakestoreapiexample

import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
	// Create an HttpLoggingInterceptor to log HTTP request and response data
	private val loggingInterceptor = HttpLoggingInterceptor().apply {
		level = HttpLoggingInterceptor.Level.BODY // Log the body of HTTP requests and responses
	}

	// Create an OkHttpClient and add the logging interceptor to it
	private val client = okhttp3.OkHttpClient.Builder()
		.addInterceptor(loggingInterceptor) // Add the logging interceptor
		.build() // Build the OkHttpClient

	// Create a Retrofit instance lazily
	private val retrofit by lazy {
		Retrofit.Builder()
			.baseUrl(BASE_URL) // Set the base URL for the API
			.addConverterFactory(GsonConverterFactory.create()) // Add a converter factory for JSON serialization/deserialization
			.client(client) // Set the OkHttpClient for network requests
			.build() // Build the Retrofit instance
	}

	// Create an implementation of the ProductEndPoint API interface lazily
	val api: ProductEndPoint by lazy {
		retrofit.create(ProductEndPoint::class.java) // Create the API implementation
	}
}