package com.dracula.fakestoreapiexample.users

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dracula.fakestoreapiexample.domain.UserRepository
import com.dracula.fakestoreapiexample.user.UserEvent
import kotlinx.coroutines.launch

class UsersViewModel: ViewModel() {
    private val userRepo = UserRepository()

    private val _state = mutableStateOf(UsersState())
    var state: State<UsersState> = _state

    private val _errorMessage = mutableStateOf<String?>(null)
    var errorMessage: State<String?> = _errorMessage

    init {
        getAllUser()
    }

    private fun getAllUser() {
        viewModelScope.launch {
            val user = userRepo.getAllUsers()
            if (user.isSuccess) {
                _state.value = state.value.copy(
                    users = user.getOrNull()
                )
            } else {
                _errorMessage.value = user.exceptionOrNull()?.message
            }
        }
    }
        fun onEvent(event: UsersEvent) {
            viewModelScope.launch {
                when (event) {
                    is UsersEvent.OrderLimitedUsers -> {
                        val response = userRepo.getLimitedUser(event.limit)
                        if (response.isSuccess) {
                            _state.value = state.value.copy(
                                users = response.getOrNull()
                            )
                        } else {
                            _errorMessage.value = response.exceptionOrNull()?.message
                        }
                    }

                    is UsersEvent.OrderType -> {
                        val sortedUsers = userRepo.getSortedUser(event.orderType)
                        if (sortedUsers.isSuccess) {
                            _state.value = state.value.copy(
                                users = sortedUsers.getOrNull()
                            )
                        } else {
                            _errorMessage.value = sortedUsers.exceptionOrNull()?.message
                        }
                    }

                    is UsersEvent.DeleteUser -> {
                        val deleteUser = userRepo.deleteUserById(event.id)
                        if (deleteUser.isSuccess) {
                            _state.value = state.value.copy(
                                users = state.value.users?.filter {
                                    it.id != event.id
                                }
                            )
                        } else {
                            _errorMessage.value = deleteUser.exceptionOrNull()?.message
                        }
                    }
                }
            }
        }
    }
