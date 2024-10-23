package com.dracula.fakestoreapiexample.ResultStates

sealed class ResultWrapper<T> {
    data class Success<T>(val data: T): ResultWrapper<T>()
    data class Error(val error: Exception): ResultWrapper<Nothing>()
    object Loading: ResultWrapper<Nothing>()
}