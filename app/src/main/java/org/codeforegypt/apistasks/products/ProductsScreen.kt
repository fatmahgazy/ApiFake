package org.codeforegypt.apistasks.products

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import org.codeforegypt.apistasks.ProductsDetails

import org.codeforegypt.apistasks.R
import org.codeforegypt.apistasks.model.ProductResponse
import org.codeforegypt.apistasks.model.Rating


@Composable
fun ProductRoot(
    navController: NavController,
    categoryName: String,
    viewModel: ProductViewModel = viewModel()
) {
    val state = viewModel.state.value
    ProductsScreen(state = state, navController = navController)
    LaunchedEffect(key1 = categoryName){
        viewModel.getProductsFormCategories(categoryName)
    }
}


@Composable
fun ProductsScreen(
    navController: NavController,
    state: ProductsState
) {
        LazyVerticalGrid(
     columns =GridCells.Fixed(2) ,
     modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(20.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp),
     contentPadding = PaddingValues(horizontal = 16.dp , vertical = 16.dp)
 ){
    items(state.products){
        product ->
        ProductItems(product = product,
            onClick = {
                navController.navigate(
                   ProductsDetails(
                       image = it.image,
                       title = it.title,
                       description = it.description,
                       price = it.price.toString()
                   )
                )
            }
            )
    }
        }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductItems(product: ProductResponse , onClick: (ProductResponse) -> Unit) {

    val context = LocalContext.current
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(Color.White),
        elevation = CardDefaults.cardElevation(4.dp),
        shape = RoundedCornerShape(4.dp),
        onClick = {
            onClick(product)
        }

    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
                .clickable {
                           onClick(product)
                },
        ) {
         AsyncImage(
             model =ImageRequest.Builder(context)
                 .data(product.image)
                 .crossfade(true)
                 .build(),
             contentDescription ="",
             placeholder = painterResource(id = R.drawable.ic_launcher_background),
             modifier = Modifier
                 .fillMaxWidth()
                 .padding(5.dp)
                 .size(150.dp),
             contentScale = ContentScale.Fit
             )

            Text(
                modifier = Modifier.padding(start = 10.dp),
                text = product.title,
                maxLines = 1,
                fontWeight = FontWeight.Bold,
                fontSize = 17.sp
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                modifier = Modifier.padding(start = 10.dp),
                text = product.description,
                maxLines = 3,
                fontSize = 14.sp,
                color = Color.LightGray,
                fontWeight = FontWeight.Normal
            )
            Spacer(modifier = Modifier.height(20.dp))
        }

    }
    
}
@Preview(showBackground = true , showSystemUi = true)
@Composable
fun ProductScreenPreview() {
//    ProductsScreen(
//        state = ProductsState(
//            products = listOf(
//            ProductResponse(
//                id = "1",
//					title = "Product 1",
//					price = 100.0,
//					description = "Description 1",
//					category = "Category 1",
//					image = "Image 1",
//				rating = Rating(
//						rate = 4.5,
//						count = 100
//)
//
//        ),
//                        ProductResponse(
//                            id = "1",
//                            title = "Product 1",
//                            price = 100.0,
//                            description = "Description 1",
//                            category = "Category 1",
//                            image = "Image 1",
//                            rating = Rating(
//                                rate = 4.5,
//                                count = 100
//                            )
//
//                        ),
//            )
//        )
//    )

    
}