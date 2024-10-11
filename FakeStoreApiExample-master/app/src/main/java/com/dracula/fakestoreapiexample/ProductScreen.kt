package com.dracula.fakestoreapiexample

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun ProductRoot(
	viewModel: ProductViewModel = viewModel(),
) {
	//TODO: 1- Observe the state from the ViewModel.
	//TODO: 2- Call ProductScreen composable with the state.
}

@Composable
fun ProductScreen(
	state: ProductScreenState,
) {
	// TODO: 1- Add LazyColumn here
	// TODO: 2- Iterate over state.products
	// TODO: 3- Call ProductItem composable for each product
}

@Composable
private fun ProductItem(product: ProductResponse) {
	val context = LocalContext.current
	Column(
		modifier = Modifier
			.fillMaxWidth()
			.clickable {
				// TODO: Show a Toast message when the product is clicked
			}
	) {
		// TODO: Display the product title
		// TODO: Display the product price
		// TODO: Display the product description
		// TODO: Display the product category
		// TODO: Display the product image
		// TODO: Display the product rating
	}
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun ProductScreenPreview() {
	ProductScreen(
		state = ProductScreenState(
			products = listOf(
				ProductResponse(
					id = 1,
					title = "Product 1",
					price = 100.0,
					description = "Description 1",
					category = "Category 1",
					image = "Image 1",
					rating = Rating(
						rate = 4.5,
						count = 100
					)
				),
				ProductResponse(
					id = 2,
					title = "Product 2",
					price = 200.0,
					description = "Description 2",
					category = "Category 2",
					image = "Image 2",
					rating = Rating(
						rate = 4.0,
						count = 200
					)
				),
				ProductResponse(
					id = 3,
					title = "Product 3",
					price = 300.0,
					description = "Description 3",
					category = "Category 3",
					image = "Image 3",
					rating = Rating(
						rate = 3.5,
						count = 300
					)
				),
				ProductResponse(
					id = 3,
					title = "Product 3",
					price = 300.0,
					description = "Description 3",
					category = "Category 3",
					image = "Image 3",
					rating = Rating(
						rate = 3.5,
						count = 300
					)
				),
				ProductResponse(
					id = 3,
					title = "Product 3",
					price = 300.0,
					description = "Description 3",
					category = "Category 3",
					image = "Image 3",
					rating = Rating(
						rate = 3.5,
						count = 300
					)
				),
				ProductResponse(
					id = 3,
					title = "Product 3",
					price = 300.0,
					description = "Description 3",
					category = "Category 3",
					image = "Image 3",
					rating = Rating(
						rate = 3.5,
						count = 300
					)
				),
				ProductResponse(
					id = 3,
					title = "Product 3",
					price = 300.0,
					description = "Description 3",
					category = "Category 3",
					image = "Image 3",
					rating = Rating(
						rate = 3.5,
						count = 300
					)
				),
				ProductResponse(
					id = 3,
					title = "Product 3",
					price = 300.0,
					description = "Description 3",
					category = "Category 3",
					image = "Image 3",
					rating = Rating(
						rate = 3.5,
						count = 300
					)
				),
				ProductResponse(
					id = 3,
					title = "Product 3",
					price = 300.0,
					description = "Description 3",
					category = "Category 3",
					image = "Image 3",
					rating = Rating(
						rate = 3.5,
						count = 300
					)
				),
				ProductResponse(
					id = 3,
					title = "Product 3",
					price = 300.0,
					description = "Description 3",
					category = "Category 3",
					image = "Image 3",
					rating = Rating(
						rate = 3.5,
						count = 300
					)
				)

			)
		)
	)
}