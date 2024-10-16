package com.dracula.fakestoreapiexample.users

import com.dracula.fakestoreapiexample.model.UserResponse

data class UsersState(
    val users: List<UserResponse>? = emptyList()
)