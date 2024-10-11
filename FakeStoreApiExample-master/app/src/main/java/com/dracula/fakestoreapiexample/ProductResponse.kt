package com.dracula.fakestoreapiexample


/**
 * This json response is an example of a product response from the Fake Store API.
 * {
 *   "id": 1,
 *   "title": "Sample Product",
 *   "price": 29.99,
 *   "category": "Electronics",
 *   "description": "A sample product description.",
 *   "image": "https://example.com/image.jpg",
 *   "rating": {
 *     "rate": 4.5,
 *     "count": 120
 *   }
 * }
 */
data class ProductResponse(
	val id: Int,
	val title: String,
	val price: Double,
	val category: String,
	val description: String,
	val image: String,
	val rating: Rating,
)

data class Rating(
	val rate: Double,
	val count: Int,
)