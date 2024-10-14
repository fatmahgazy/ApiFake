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

    init {
        getAllUser()
    }

  private fun getAllUser(){
        viewModelScope.launch {
            val user = userRepo.getAllUsers()
            _state.value = state.value.copy(
                users = user
            )
        }
    }
    fun onEvent(event: UsersEvent){
        viewModelScope.launch {
            when(event){
                is UsersEvent.OrderLimitedUsers ->{
                    val response = userRepo.getLimitedUser(event.limit)
                    _state.value = state.value.copy(
                        users = response
                    )
                }
                is UsersEvent.OrderType -> {
                    val sortedUsers = userRepo.getSortedUser(event.orderType)
                    _state.value =state.value.copy(
                        users = sortedUsers
                    )
                }
                is UsersEvent.DeleteUser -> {
                    val deleteUser = userRepo.deleteUserById(event.id)
                    if (deleteUser) {
                        _state.value = state.value.copy(
                            users = state.value.users.filter {
                                it.id != event.id
                            }
                        )
                    }
                }
            }
        }
    }

}