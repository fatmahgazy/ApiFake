package com.dracula.fakestoreapiexample.user

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dracula.fakestoreapiexample.ResultStates.ResultWrapper
import com.dracula.fakestoreapiexample.ResultStates.UiText
import com.dracula.fakestoreapiexample.domain.UserRepository
import kotlinx.coroutines.launch

class UserByIdViewModel: ViewModel() {
    private val repo = UserRepository()

    private val _state = mutableStateOf(UserState())
    var state: State<UserState> = _state

    private val _errorMessage = mutableStateOf<UiText?>(null)
    var errorMessage: State<UiText?> = _errorMessage

    fun onEvent(event: UserEvent) {
        viewModelScope.launch {
            when (event) {
                is UserEvent.GetUser -> {
                    val userResponse = repo.getUserById(event.id)
                   when(userResponse){
                       is ResultWrapper.Success -> _state.value = state.value.copy(
                           user = userResponse.data
                       )
                       is ResultWrapper.Error -> _errorMessage.value = userResponse.error
                   }
                }
            }
    }

    }
}