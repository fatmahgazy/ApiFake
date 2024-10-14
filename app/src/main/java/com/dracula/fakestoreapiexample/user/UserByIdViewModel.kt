package com.dracula.fakestoreapiexample.user

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dracula.fakestoreapiexample.domain.UserRepository
import kotlinx.coroutines.launch

class UserByIdViewModel: ViewModel() {
    private val repo = UserRepository()

    private val _state = mutableStateOf(UserState())
    var state: State<UserState> = _state

    fun onEvent(event: UserEvent) {
        viewModelScope.launch {
            when (event) {
            is UserEvent.GetUser -> {
               val user =  repo.getUserById(event.id)
                _state.value = state.value.copy(
                    user = user
                )
            }

            }
    }

    }
}