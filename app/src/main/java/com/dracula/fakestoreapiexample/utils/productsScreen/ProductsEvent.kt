package com.dracula.fakestoreapiexample.utils.productsScreen

sealed class ProductsEvent {
    data class Order(val order: String): ProductsEvent()
    data class LimitProducts(val limit: Int): ProductsEvent()

}