package com.dracula.fakestoreapiexample.user

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun UserDetails(
     userId: String,
     viewModel: UserByIdViewModel = viewModel()
) {
    LaunchedEffect(key1 = userId ){
        viewModel.onEvent(UserEvent.GetUser(userId))
    }
    val state = viewModel.state.value
    val errorMessage = viewModel.errorMessage.value
    val user = state.user
    Column (
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    )
    {
            when{
                user != null -> {
                    Text(
                        text = "${user.name.firstName} ${user.name.lastName}"
                    )
                    Text(
                        text = user.email
                    )
                    Text(
                        text = user.password
                    )
                    Text(
                        text = user.phone
                    )
                    Text(
                        text = "${user.address.city}, ${user.address.street}, ${user.address.zipCode}, (${user.address.geolocation}"
                    )
                }
                    errorMessage.isNullOrBlank() -> {
                        Text(text = errorMessage ?: "")
                }
            }
        }
    }

