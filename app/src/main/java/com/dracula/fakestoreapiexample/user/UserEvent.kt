package com.dracula.fakestoreapiexample.user

sealed class UserEvent {
    data class GetUser(val id: String): UserEvent()
}