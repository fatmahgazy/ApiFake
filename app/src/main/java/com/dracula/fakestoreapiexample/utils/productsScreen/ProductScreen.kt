package com.dracula.fakestoreapiexample.utils.productsScreen

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.dracula.fakestoreapiexample.R
import com.dracula.fakestoreapiexample.model.ProductResponse
import com.dracula.fakestoreapiexample.utils.ProductDetails

@Composable
fun ProductRoot(
	categoryName: String,
	navController: NavController,
	viewModel: ProductViewModel = viewModel()
) {
	//TODO: 1- Observe the state from the ViewModel.
	val state = viewModel.state.value
	ProductScreen(state = state, navController = navController){
		viewModel.onEvent(it)
	}


	LaunchedEffect(categoryName) {
		viewModel.getProductsForCategory(categoryName)
	}
	//TODO: 2- Call ProductScreen composable with the state.

}

@Composable
fun ProductScreen(
	navController: NavController,
	state: ProductScreenState,
	onEvent: (ProductsEvent) -> Unit

) {
	Column(
		modifier = Modifier.statusBarsPadding()
	){
		Row(
			modifier = Modifier.fillMaxWidth()
				.padding(25.dp),
			horizontalArrangement = Arrangement.spacedBy(10.dp)
		) {
			Button(
				onClick = {
					onEvent(ProductsEvent.Order("asc"))
				}) {
				Text(text = "ASD")
			}
			Button(
				onClick = {
					onEvent(ProductsEvent.Order("desc"))
				}) {
				Text(text = "DESC")
			}
		}
		// TODO: 1- Add LazyColumn here
		LazyVerticalGrid(
			columns = GridCells.Fixed(2),
			modifier = Modifier
				.fillMaxSize(),
			contentPadding = PaddingValues(horizontal = 16.dp, vertical = 16.dp)
		) {
			items(state.products) { product ->
				ProductItem(
					product = product,
					onClick = {
						navController.navigate(
							ProductDetails(
								title = product.title,
								description = product.description,
								image = product.image,
								price = product.price.toString()
							)
						)
					}
				)
			}
		}
	}
}

	// TODO: 2- Iterate over state.products
	// TODO: 3- Call ProductItem composable for each product


@Composable
private fun ProductItem(product: ProductResponse, modifier: Modifier = Modifier, onClick: () -> Unit) {
	val context = LocalContext.current
	val image = product.image
	val description = product.description
	val title = product.title
	Card(
		modifier = modifier
			.fillMaxWidth()
			.padding(16.dp),
		colors = CardDefaults.cardColors(Color.White),
		elevation = CardDefaults.cardElevation(4.dp),
		shape = RoundedCornerShape(6.dp),
		onClick = onClick
	) {
		Column(
			modifier = Modifier
				.fillMaxWidth()
				.clickable {
					// TODO: Show a Toast message when the product is clicked
					onClick()
				},
			verticalArrangement = Arrangement.spacedBy(7.dp)
		) {
				 AsyncImage(
					model = ImageRequest.Builder(context)
						.data(image)
						.crossfade(true)
						.build(),
					placeholder = painterResource(id = R.drawable.ic_launcher_background),
					contentDescription = " ",
					contentScale = ContentScale.Fit,
					modifier = Modifier
						.fillMaxWidth()
						.size(145.dp)
				)
			Text(
				text = title,
				modifier = Modifier.padding(horizontal = 16.dp),
				maxLines = 1,
				style = MaterialTheme.typography.bodyLarge,
				color = Color.Black
			)
			Text(
				text = description,
				modifier = Modifier.padding(horizontal = 16.dp),
				maxLines = 1,
				style = MaterialTheme.typography.bodySmall,
				color = Color.Gray.copy(alpha = .8f)
			)
			Spacer(modifier = Modifier.height(8.dp))
				// TODO: Display the product title
				// TODO: Display the product price
				// TODO: Display the product description
				// TODO: Display the product category
				// TODO: Display the product image
				// TODO: Display the product rating

			}
		}

	}



//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//private fun ProductScreenPreview() {
//	ProductScreen(
//		state = ProductScreenState(
//			products = listOf(
//				ProductResponse(
//					id = 1,
//					title = "Product 1",
//					price = 100.0,
//					description = "Description 1",
//					category = "Category 1",
//					image = "Image 1",
//					rating = Rating(
//						rate = 4.5,
//						count = 100
//					)
//				),
//				ProductResponse(
//					id = 2,
//					title = "Product 2",
//					price = 200.0,
//					description = "Description 2",
//					category = "Category 2",
//					image = "Image 2",
//					rating = Rating(
//						rate = 4.0,
//						count = 200
//					)
//				),
//				ProductResponse(
//					id = 3,
//					title = "Product 3",
//					price = 300.0,
//					description = "Description 3",
//					category = "Category 3",
//					image = "Image 3",
//					rating = Rating(
//						rate = 3.5,
//						count = 300
//					)
//				),
//				ProductResponse(
//					id = 3,
//					title = "Product 3",
//					price = 300.0,
//					description = "Description 3",
//					category = "Category 3",
//					image = "Image 3",
//					rating = Rating(
//						rate = 3.5,
//						count = 300
//					)
//				),
//				ProductResponse(
//					id = 3,
//					title = "Product 3",
//					price = 300.0,
//					description = "Description 3",
//					category = "Category 3",
//					image = "Image 3",
//					rating = Rating(
//						rate = 3.5,
//						count = 300
//					)
//				),
//				ProductResponse(
//					id = 3,
//					title = "Product 3",
//					price = 300.0,
//					description = "Description 3",
//					category = "Category 3",
//					image = "Image 3",
//					rating = Rating(
//						rate = 3.5,
//						count = 300
//					)
//				),
//				ProductResponse(
//					id = 3,
//					title = "Product 3",
//					price = 300.0,
//					description = "Description 3",
//					category = "Category 3",
//					image = "Image 3",
//					rating = Rating(
//						rate = 3.5,
//						count = 300
//					)
//				),
//				ProductResponse(
//					id = 3,
//					title = "Product 3",
//					price = 300.0,
//					description = "Description 3",
//					category = "Category 3",
//					image = "Image 3",
//					rating = Rating(
//						rate = 3.5,
//						count = 300
//					)
//				),
//				ProductResponse(
//					id = 3,
//					title = "Product 3",
//					price = 300.0,
//					description = "Description 3",
//					category = "Category 3",
//					image = "Image 3",
//					rating = Rating(
//						rate = 3.5,
//						count = 300
//					)
//				),
//				ProductResponse(
//					id = 3,
//					title = "Product 3",
//					price = 300.0,
//					description = "Description 3",
//					category = "Category 3",
//					image = "Image 3",
//					rating = Rating(
//						rate = 3.5,
//						count = 300
//					)
//				)
//
//			)
//		)
//	)
//}