package com.dracula.fakestoreapiexample.utils
import com.dracula.fakestoreapiexample.model.UserAddress
import com.dracula.fakestoreapiexample.model.UserName
import kotlinx.serialization.Serializable

@Serializable
data class ProductsScreen(
    val category: String
)

@Serializable
object CategoryScreen

@Serializable
data class ProductDetails(
    val title: String,
    val description: String,
    val image: String,
    val price: String
)
@Serializable
object UsersScreen

@Serializable
data class UserDetails(
    val id: String

)