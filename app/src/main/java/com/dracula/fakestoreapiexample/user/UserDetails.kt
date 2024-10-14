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
    val user = state.user
    Column (
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    )
    {
        user?.let {
            Text(
                text = "${it.name.firstName} ${it.name.lastName}"
            )
            Text(
                text = it.email
            )
            Text(
                text = it.password
            )
            Text(
                text = it.phone
            )
            Text(
                text = "${it.address.city}, ${it.address.street}, ${it.address.zipCode}, (${it.address.geolocation}"
            )


        }
    }

}