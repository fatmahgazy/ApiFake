package com.dracula.fakestoreapiexample.ResultStates

import android.content.Context

sealed class UiText{
    data class DynamicText(val value: String): UiText()
    data class StringResource(val resId: Int ): UiText()

    fun asString(context: Context): String {
        return when (this) {
            is DynamicText -> value
            is StringResource -> context.getString(resId)
        }
    }
}