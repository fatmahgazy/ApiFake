package com.dracula.fakestoreapiexample.api

import com.dracula.fakestoreapiexample.model.UserResponse
import retrofit2.Response
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface UserEndPoint {
    @GET("users")
    suspend fun getUsers(): List<UserResponse>
    @GET("users/{id}")
    suspend fun getUserById(
        @Path("id") id: String
    ):UserResponse?
    @GET("users")
    suspend fun getLimitedUser(
        @Query("limit") userLimited: String
    ): List<UserResponse>

    @GET("users")
    suspend fun getSortedUser(
        @Query("sort") sortedType: String
    ): List<UserResponse>

    @DELETE("users/{id}")
    suspend fun deleteUserById(
        @Path("id") id: String
    ):List<UserResponse>
}