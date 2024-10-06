package org.codeforegypt.apistasks.category


import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import org.codeforegypt.apistasks.ProductsScreen

@Composable
fun CategoryRoot(
    navController: NavController,
    viewModel: CategoryViewModel = viewModel()
) {
    val state = viewModel.state.value
    CategoryScreen(
        state = state,
        onclick = {
            navController.navigate(ProductsScreen(category = it))
        },

        )
}

@Composable
fun CategoryScreen(
    state: CategoryState,
    onclick: (String) -> Unit
) {
    LazyColumn{
        items(state.category){
            category ->
            Text(
                modifier = Modifier.clickable {
                        onclick(category)
                },
                text = category,
                color = Color.Yellow,
                fontSize = 15.sp,
                fontWeight = FontWeight.SemiBold
            )
        }
    }

}
@Preview(showBackground = true , showSystemUi = true)
@Composable
fun CategoryScreenPreview() {

}