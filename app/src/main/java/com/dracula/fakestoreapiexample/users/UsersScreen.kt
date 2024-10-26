package com.dracula.fakestoreapiexample.users

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
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.dracula.fakestoreapiexample.R
import com.dracula.fakestoreapiexample.model.UserResponse
import com.dracula.fakestoreapiexample.utils.UserDetails


@Composable
fun UsersRoot(
    navController: NavController,
    viewModel: UsersViewModel = viewModel()
) {
    val state = viewModel.state.value
    val errorMessage = viewModel.errorMessage.value
    val context = LocalContext.current
    UsersScreen(state = state, errorMessage = errorMessage?.asString(context) ?: "", navController = navController){
        viewModel.onEvent(it)
    }
}
@Composable
fun UsersScreen(
    navController: NavController,
    state: UsersState,
    errorMessage: String,
    onEvent: (UsersEvent) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .systemBarsPadding()
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier,
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Button(
                onClick = {
                    onEvent(UsersEvent.OrderLimitedUsers("5"))
                }
            ) {
                Text(
                    text = stringResource(id = R.string.show_5)
                )
            }
            Button(
                onClick = {
                    onEvent(UsersEvent.OrderLimitedUsers("8"))
                }
            ) {
                Text(
                    text =  stringResource(id = R.string.show_8)
                )
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            modifier = Modifier,
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Button(
                onClick = {
                    onEvent(UsersEvent.OrderType("asc"))
                }
            ) {
                Text(
                    text = stringResource(id = R.string.asc)
                )
            }
            Button(
                onClick = {
                    onEvent(UsersEvent.OrderType("desc"))
                }
            ) {
                Text(
                    text = stringResource(id = R.string.DESC)
                )
            }
        }
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding()
                .padding(top = 20.dp),
            contentPadding = PaddingValues(horizontal = 25.dp)
        ) {
            when {
                state.users?.isNotEmpty() == true -> {
                    items(state.users) { user ->
                        UsersItems(
                            user = user,
                            onClick = {
                                navController.navigate(UserDetails(id = user.id))
                            },
                            {
                                onEvent(UsersEvent.DeleteUser(id = user.id))
                            }
                        )

                        Spacer(modifier = Modifier.height(20.dp))
                    }
                }
                errorMessage.isNotBlank() -> {
                    item {
                        Text(
                            text = errorMessage
                        )
                    }
            }

        }
        }
    }
}

@Composable
fun UsersItems(user: UserResponse , onClick: () -> Unit , deleteOnClick: () -> Unit) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(Color.White),
        elevation = CardDefaults.cardElevation(4.dp),
        shape = RoundedCornerShape(10.dp),
        onClick = onClick
    ) {
        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            Text(
                text = "${user.name?.firstName ?: "Unknown"} ${user.name?.lastName ?: ""}",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Black
            )
            Text(
                text =user.email,
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Black
            )
            Text(
                text = user.password,
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Black
            )
            Text(
                text = user.phone,
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Black
            )
            Text(
                text = "${user.address?.city ?: ""}, ${user.address?.street ?: ""}, ${user.address?.zipCode ?: ""}",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Black
            )

        }
            Icon(
                imageVector = Icons.Default.Delete,
                contentDescription = "",
                        modifier = Modifier
                            .size(50.dp)
                            .clickable {
                                deleteOnClick()
                            }
            )
    }
}
