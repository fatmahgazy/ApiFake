package org.codeforegypt.apistasks.model


data class ProductResponse(
    val id: String,
    val title: String,
    val price: Double,
    val category: String,
    val description:String,
    val image:String,
    val rating: Rating
)
data class Rating(
    val rate: Double,
    val count: Int,
)
