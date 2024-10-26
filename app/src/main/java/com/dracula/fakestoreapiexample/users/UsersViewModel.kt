package com.dracula.fakestoreapiexample.users

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dracula.fakestoreapiexample.ResultStates.ResultWrapper
import com.dracula.fakestoreapiexample.ResultStates.UiText
import com.dracula.fakestoreapiexample.domain.UserRepository
import com.dracula.fakestoreapiexample.user.UserEvent
import kotlinx.coroutines.launch

class UsersViewModel: ViewModel() {
    private val userRepo = UserRepository()

    private val _state = mutableStateOf(UsersState())
    var state: State<UsersState> = _state

    private val _errorMessage = mutableStateOf<UiText?>(null)
    var errorMessage: State<UiText?> = _errorMessage

    init {
        getAllUser()
    }

    private fun getAllUser() {
        viewModelScope.launch {
            val userResponse = userRepo.getAllUsers()
           when(userResponse){
               is ResultWrapper.Success -> _state.value = state.value.copy(
                   users = userResponse.data
               )
               is ResultWrapper.Error -> _errorMessage.value = userResponse.error
           }
        }
    }
        fun onEvent(event: UsersEvent) {
            viewModelScope.launch {
                when (event) {
                    is UsersEvent.OrderLimitedUsers -> {
                        val response = userRepo.getLimitedUser(event.limit)
                       when(response){
                           is ResultWrapper.Success -> _state.value = state.value.copy(
                               users = response.data
                           )
                           is ResultWrapper.Error -> _errorMessage.value = response.error

                       }                       }

                    is UsersEvent.OrderType -> {
                        val sortedUsers = userRepo.getSortedUser(event.orderType)
                      when(sortedUsers){
                          is ResultWrapper.Success -> _state.value = state.value.copy(
                              users = sortedUsers.data
                          )
                          is ResultWrapper.Error -> _errorMessage.value = sortedUsers.error
                      }
                    }

                    is UsersEvent.DeleteUser -> {
                        val deleteUser = userRepo.deleteUserById(event.id)
                      when(deleteUser){
                          is ResultWrapper.Success -> _state.value = state.value.copy(
                              users = deleteUser.data
                          )
                          is ResultWrapper.Error -> _errorMessage.value = deleteUser.error
                      }
                    }
                }
            }
        }
    }
