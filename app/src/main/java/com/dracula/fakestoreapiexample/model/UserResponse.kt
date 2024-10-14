package com.dracula.fakestoreapiexample.model

import kotlinx.serialization.Serializable

@Serializable
data class UserResponse(
    val id: String,
    val email: String,
    val password: String,
    val name: UserName,
    val address: UserAddress,
    val phone: String


)
@Serializable
data class UserName(
    val firstName: String,
    val lastName: String
)
@Serializable
data class UserAddress(
    val city: String,
    val street: String,
    val number: Int,
    val zipCode: String,
    val geolocation: Geolocation
)
@Serializable
data class Geolocation(
    val lat: String,
    val long: String
)