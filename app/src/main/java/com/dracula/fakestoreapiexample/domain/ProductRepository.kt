package com.dracula.fakestoreapiexample.domain

import com.dracula.fakestoreapiexample.R
import com.dracula.fakestoreapiexample.ResultStates.ResultWrapper
import com.dracula.fakestoreapiexample.ResultStates.UiText
import com.dracula.fakestoreapiexample.api.RetrofitInstance
import com.dracula.fakestoreapiexample.model.ProductResponse
import com.dracula.fakestoreapiexample.utils.safeApiCall
import java.net.SocketTimeoutException
import java.net.UnknownHostException



class ProductRepository {
    // TODO: Initialize the Retrofit API instance
    private val api = RetrofitInstance.api

    // TODO: Create a suspend function to fetch products from the API
    suspend fun getProducts(): ResultWrapper<List<ProductResponse>> {
        // TODO: Make the API call to get products
        return try {
            val response = api.getProducts()
            ResultWrapper.Success(response)
        } catch (e: Exception) {
            when (e) {
                is UnknownHostException -> {
                    ResultWrapper.Error(UiText.StringResource(R.string.unknown_exception_msg))
                }

                is SocketTimeoutException -> {
                    ResultWrapper.Error(UiText.StringResource(R.string.Timeout_Exception))
                }

                else -> {
                    ResultWrapper.Error(UiText.DynamicText("${e.message}"))
                }
            }

        }
    }

    suspend fun getCategories(): ResultWrapper<List<String>> {
        return safeApiCall {
            api.getCategories()
        }
    }

    suspend fun getProductsForCategory(category: String): ResultWrapper<List<ProductResponse>> {
        return try {
            val response = api.getProductsForCategory(category)
            ResultWrapper.Success(response)
        } catch (e: Exception) {
            when (e) {
                is UnknownHostException -> {
                    ResultWrapper.Error(UiText.StringResource(R.string.unknown_exception_msg))
                }

                is SocketTimeoutException -> {
                    ResultWrapper.Error(UiText.StringResource(R.string.Timeout_Exception))
                }

                else -> {
                    ResultWrapper.Error(UiText.DynamicText("${e.message}"))

                }
            }
        }
    }

    suspend fun getSortedItems(sort: String): ResultWrapper<List<ProductResponse>> {
        return try {
            val response = api.getSortedItems(sort)
            ResultWrapper.Success(response)
        } catch (t: Throwable) {
            when (t) {
                is UnknownHostException -> {
                    ResultWrapper.Error(UiText.StringResource(R.string.unknown_exception_msg))
                }

                is SocketTimeoutException -> {
                    ResultWrapper.Error(UiText.StringResource(R.string.Timeout_Exception))
                }
                else -> {
                    ResultWrapper.Error(UiText.DynamicText("${t.message}"))
                }
            }
        }
    }

    suspend fun getLimitedProducts(limit: Int): ResultWrapper<List<ProductResponse>> {
        return try {
            val response = api.getLimitedProducts(limit)
            ResultWrapper.Success(response)
        } catch (t: Throwable) {
            when (t) {
                is UnknownHostException -> {
                    ResultWrapper.Error(UiText.StringResource(R.string.unknown_exception_msg))
                }

                is SocketTimeoutException -> {
                    ResultWrapper.Error(UiText.StringResource(R.string.Timeout_Exception))
                }
                else -> {
                    ResultWrapper.Error(UiText.DynamicText("${t.message}"))
                }
            }

        }
    }

}
