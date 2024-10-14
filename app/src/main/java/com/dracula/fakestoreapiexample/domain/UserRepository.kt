package com.dracula.fakestoreapiexample.domain

import android.util.Log
import com.dracula.fakestoreapiexample.api.RetrofitInstance
import com.dracula.fakestoreapiexample.model.UserResponse

class UserRepository {
    private val userApi = RetrofitInstance.userApi

    suspend fun getAllUsers(): List<UserResponse>{
        return try {
            val userResponse = userApi.getUsers()
             userResponse
        }catch (t: Throwable){
            emptyList()
        }

    }
    suspend fun getUserById(id: String): UserResponse?{
        return try {
            val response = userApi.getUserById(id)
            response
        }catch (t: Throwable){
            null
        }
    }
    suspend fun getLimitedUser(userLimited: String): List<UserResponse>{
        return try {
            val limitResponse = userApi.getLimitedUser(userLimited)
            limitResponse
        }
        catch (t: Throwable){
            emptyList()
        }
    }
    suspend fun getSortedUser(id: String): List<UserResponse>{
        return try {
            val response = userApi.getSortedUser(id)
            response
        }
        catch (t: Throwable){
            emptyList()
        }

    }
    suspend fun deleteUserById(id: String): Boolean{
        return try {
            val response = userApi.deleteUserById(id)
            response
        }
        catch (t: Throwable){
            false
        }

    }
}