package org.codeforegypt.apistasks.products

import org.codeforegypt.apistasks.model.ProductResponse

data class ProductsState(
    val products: List<ProductResponse> = emptyList()
)