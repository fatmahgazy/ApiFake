package com.dracula.fakestoreapiexample.domain

import android.util.Log
import com.dracula.fakestoreapiexample.api.RetrofitInstance
import com.dracula.fakestoreapiexample.model.UserResponse

class UserRepository {
    private val userApi = RetrofitInstance.userApi

    suspend fun getAllUsers(): Result<List<UserResponse>>{
        return try {
            val userResponse = userApi.getUsers()
             Result.success(userResponse)
        }catch (t: Throwable){
            Result.failure(t)
        }

    }
    suspend fun getUserById(id: String): Result<UserResponse?>{
        return try {
            val response = userApi.getUserById(id)
            Result.success(response)
        }catch (t: Throwable){
            Result.failure(t)
        }
    }
    suspend fun getLimitedUser(userLimited: String): Result<List<UserResponse>>{
        return try {
            val limitResponse = userApi.getLimitedUser(userLimited)
            Result.success(limitResponse)
        }
        catch (t: Throwable){
            Result.failure(t)
        }
    }
    suspend fun getSortedUser(id: String): Result<List<UserResponse>>{
        return try {
            val response = userApi.getSortedUser(id)
            Result.success(response)
        }
        catch (t: Throwable){
           Result.failure(t)
        }

    }
    suspend fun deleteUserById(id: String): Result<Boolean>{
        return try {
            val response = userApi.deleteUserById(id)
            Result.success(response)
        }
        catch (t: Throwable){
            Result.failure(t)
        }

    }
}