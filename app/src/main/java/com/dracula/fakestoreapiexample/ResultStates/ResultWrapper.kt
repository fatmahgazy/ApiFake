package com.dracula.fakestoreapiexample.ResultStates

sealed class ResultWrapper<out T> {
    data class Success<T>(val data: T): ResultWrapper<T>()
    data class Error(val error: UiText): ResultWrapper<Nothing>()
}