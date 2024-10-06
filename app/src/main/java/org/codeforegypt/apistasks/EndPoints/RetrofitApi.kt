package org.codeforegypt.apistasks.EndPoints


import okhttp3.logging.HttpLoggingInterceptor
import org.codeforegypt.apistasks.constants.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitApi {
    private val interceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }
    private val client = okhttp3.OkHttpClient.Builder()
        .addInterceptor(interceptor)
        .build()
    private val retrofit by lazy{
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }
    val api: ApiEndPoints by lazy {
        retrofit.create(ApiEndPoints::class.java)
    }
}