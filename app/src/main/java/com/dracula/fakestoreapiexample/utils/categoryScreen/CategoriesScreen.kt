package com.dracula.fakestoreapiexample.utils.categoryScreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import  androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.dracula.fakestoreapiexample.utils.ProductsScreen
import com.dracula.fakestoreapiexample.utils.productsScreen.ProductScreen

@Composable
fun CategoriesRoot(
    viewModel: CategoriesViewModel = viewModel(),
    navController: NavController
){
     val state = viewModel.state.value
    CategoryScreen(
        state = state ,
        onClickCategory = {
        navController.navigate(ProductsScreen(category = it))
    },

    )
}
@Composable
fun CategoryScreen (
    state: CategoriesState,
    onClickCategory: (String) -> Unit
) {
    LazyColumn {
        items(state.categoriesState) { category ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
                colors = CardDefaults.cardColors(Color.Yellow),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(
                    text = category,
                    modifier = Modifier
                        .padding(12.dp)
                        .fillMaxWidth()
                        .clickable {
                            onClickCategory(category)
                        }
                )
            }
        }
    }
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun CategoryScreenPreview() {
    CategoryScreen(state = CategoriesState(
        categoriesState = listOf(
            "Electronics",
            "jilewiery",
        )
    ),
        onClickCategory = {}
    )

}