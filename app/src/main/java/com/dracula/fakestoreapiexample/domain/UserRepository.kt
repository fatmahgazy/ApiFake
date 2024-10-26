package com.dracula.fakestoreapiexample.domain

import android.util.Log
import com.dracula.fakestoreapiexample.R
import com.dracula.fakestoreapiexample.ResultStates.ResultWrapper
import com.dracula.fakestoreapiexample.ResultStates.UiText
import com.dracula.fakestoreapiexample.api.RetrofitInstance
import com.dracula.fakestoreapiexample.model.UserResponse
import retrofit2.Response
import java.net.SocketTimeoutException
import java.net.UnknownHostException

class UserRepository {
    private val userApi = RetrofitInstance.userApi

    suspend fun getAllUsers(): ResultWrapper<List<UserResponse>>{
        return try {
            val userResponse = userApi.getUsers()
             ResultWrapper.Success(userResponse)
        }catch (t: Throwable){
            when(t){
                is UnknownHostException ->{
                    ResultWrapper.Error(UiText.StringResource(R.string.unknown_exception_msg))
                }
                is SocketTimeoutException ->{
                    ResultWrapper.Error(UiText.StringResource(R.string.Timeout_Exception))
                }
                else -> {
                    ResultWrapper.Error(UiText.DynamicText("${t.message}"))
                }
            }
        }

    }
    suspend fun getUserById(id: String): ResultWrapper<UserResponse?>{
        return try {
            val response = userApi.getUserById(id)
            ResultWrapper.Success(response)
        }catch (t: Throwable){
            when(t){
                is UnknownHostException ->{
                    ResultWrapper.Error(UiText.StringResource(R.string.unknown_exception_msg))
                }
                is SocketTimeoutException ->{
                    ResultWrapper.Error(UiText.StringResource(R.string.Timeout_Exception))
                }
                else -> {
                ResultWrapper.Error(UiText.DynamicText("${t.message}"))
                }
            }
        }
    }
    suspend fun getLimitedUser(userLimited: String): ResultWrapper<List<UserResponse>>{
        return try {
            val limitResponse = userApi.getLimitedUser(userLimited)
            ResultWrapper.Success(limitResponse)
        }
        catch (t: Throwable){
            when(t){
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
    suspend fun getSortedUser(id: String): ResultWrapper<List<UserResponse>>{
        return try {
            val response = userApi.getSortedUser(id)
            ResultWrapper.Success(response)
        }
        catch (t: Throwable){
            when(t){
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
    suspend fun deleteUserById(id: String): ResultWrapper<List<UserResponse>>{
        return try {
            val response = userApi.deleteUserById(id)
            ResultWrapper.Success(response)
        }
        catch (t: Throwable){
            when(t){
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