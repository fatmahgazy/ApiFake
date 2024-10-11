package com.dracula.fakestoreapiexample.utils

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.dracula.fakestoreapiexample.utils.productsScreen.ProductRoot
import com.dracula.fakestoreapiexample.utils.categoryScreen.CategoriesRoot
import com.dracula.fakestoreapiexample.ui.theme.FakeStoreApiExampleTheme
import com.dracula.fakestoreapiexample.utils.productsScreen.ProductDetailsScreen


class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		enableEdgeToEdge()
		setContent {
			FakeStoreApiExampleTheme {
				Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
					//ProductRoot()
					//CategoriesRoot()
					val navController = rememberNavController()
					NavHost(
						navController = navController, 
						startDestination = CategoryScreen
					)
					{
						composable<CategoryScreen>{
							CategoriesRoot(navController = navController)
						}
						composable<ProductsScreen> {
							val routeData = it.toRoute<ProductsScreen>()
							Log.d("MainActivity", "Category: ${routeData.category}")
							ProductRoot(navController = navController, categoryName = routeData.category)
						}
						composable<ProductDetails> {
							val routeData = it.toRoute<ProductDetails>()
							ProductDetailsScreen(
								title = routeData.title,
								description = routeData.description,
								price =routeData.price.toString(),
								imageUrl = routeData.image
							)
						}
					}

				}
			}
		}
	}
}