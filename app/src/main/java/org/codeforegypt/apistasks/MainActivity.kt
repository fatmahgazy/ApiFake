package org.codeforegypt.apistasks

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import org.codeforegypt.apistasks.category.CategoryRoot
import org.codeforegypt.apistasks.products.ProductRoot
import org.codeforegypt.apistasks.products.ProductsDetails
import org.codeforegypt.apistasks.ui.theme.ApisTasksTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ApisTasksTheme {
                // A surface container using the 'background' color from the theme
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val navController = rememberNavController()
            NavHost(
                navController = navController,
                startDestination = CategoryScreen
            ){
                composable<CategoryScreen> {
                    CategoryRoot(navController = navController)
                }
                    composable<ProductsScreen> {
                        val routeData = it.toRoute<ProductsScreen>()
                        Log.d("routeData" , "the error is : ${routeData.category}" )
                        ProductRoot(navController,categoryName = routeData.category)
                    }
                composable<ProductsDetails> {
                    val routData = it.toRoute<ProductsDetails>()
                    ProductsDetails(
                        title = routData.title,
                        image = routData.image,
                        description = routData.description,
                        price = routData.price
                    )
                }
                }
                }
            }
        }
    }
}


