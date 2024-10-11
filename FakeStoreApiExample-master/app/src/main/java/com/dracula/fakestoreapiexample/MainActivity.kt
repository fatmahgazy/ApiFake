package com.dracula.fakestoreapiexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.dracula.fakestoreapiexample.ui.theme.FakeStoreApiExampleTheme

class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		enableEdgeToEdge()
		setContent {
			FakeStoreApiExampleTheme {
				Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
					ProductRoot()
				}
			}
		}
	}
}