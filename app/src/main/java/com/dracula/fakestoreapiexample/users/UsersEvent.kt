package com.dracula.fakestoreapiexample.users

import com.dracula.fakestoreapiexample.user.UserEvent

sealed class UsersEvent {
    data class OrderLimitedUsers(val limit: String): UsersEvent()
    data class OrderType(val orderType: String): UsersEvent()
    data class DeleteUser(val id: String): UsersEvent()
}