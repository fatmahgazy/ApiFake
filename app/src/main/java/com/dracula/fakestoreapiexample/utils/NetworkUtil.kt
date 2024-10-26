package com.dracula.fakestoreapiexample.utils

import com.dracula.fakestoreapiexample.R
import com.dracula.fakestoreapiexample.ResultStates.ResultWrapper
import com.dracula.fakestoreapiexample.ResultStates.UiText
import java.net.SocketTimeoutException
import java.net.UnknownHostException

/**
 * Executes a given API call safely, handling exceptions and returning a wrapped result.
 *
 * @param T The type of the result expected from the API call.
 * @param apiCall A suspend function representing the API call to be executed.
 * @return A [ResultWrapper] containing either the successful result or an error message.
 */
suspend fun <T> safeApiCall(
	apiCall: suspend () -> T,
): ResultWrapper<T> {
	return try {
		val response = apiCall()
		ResultWrapper.Success(response)
	} catch (e: Exception) {
		when (e) {
			is UnknownHostException -> {
				ResultWrapper.Error(UiText.StringResource(R.string.unknown_exception_msg))
			}

			is SocketTimeoutException -> {
				ResultWrapper.Error(UiText.StringResource(R.string.Timeout_Exception))
			}

			else -> {
				ResultWrapper.Error(UiText.DynamicText("${e.message}"))
			}
		}
	}
}
