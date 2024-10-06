package org.codeforegypt.apistasks

import androidx.annotation.StringRes
import kotlinx.serialization.Serializable

@Serializable
object CategoryScreen

@Serializable
data class ProductsScreen(
    val category: String
)
@Serializable
data class ProductsDetails(
    val image: String,
    val title: String,
    val description: String,
    val price: String
)

