package org.codeforegypt.apistasks.domain
import android.util.Log
import org.codeforegypt.apistasks.EndPoints.RetrofitApi
import org.codeforegypt.apistasks.model.ProductResponse


class Repositry
{
    private val api = RetrofitApi.api

    suspend fun getProducts(): List<ProductResponse>{
        return try {
            val response = api.getProducts()
            response
        }
        catch (t:Throwable){
            emptyList()
        }
    }
    suspend fun getAllCategory(): List<String>{
        return try {
            val response = api.getAllCategory()
            response
        }
        catch(t: Throwable) {
            Log.d("ProductRepository","the error message is : ${t.message}")
            emptyList()

        }
    }

    suspend fun getProductsFromCategories(category: String): List<ProductResponse>{
        return try {
            val response = api.getProductsFromCategories(category)
            response

        }catch (t: Throwable){
            Log.d("getProductsFromCategories"," the error is :${t.message}")
            emptyList()
        }
    }

}