package com.dracula.fakestoreapiexample.ResultStates

import android.content.Context

sealed class UiText<T> {
    data class DynamicText<T>(val value: T): UiText<T>()
    data class StringResource<T>(val resId: Int , val args: List<Any> = emptyList()): UiText<T>()

    fun asString(context: Context): String{
        return when (this) {
            is DynamicText -> value
            is StringResource -> context.getString(resId , *args.toTypedArray())
        }
    }
}