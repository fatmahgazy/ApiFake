package com.dracula.fakestoreapiexample.utils.productsScreen

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.dracula.fakestoreapiexample.R

@Composable
fun ProductDetailsScreen(
    title: String,
    description: String,
    price: String,
    imageUrl :String
){
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                // TODO: Show a Toast message when the product is clicked
                Toast
                    .makeText(context, "clicked on ${title}", Toast.LENGTH_SHORT)
                    .show()
            },
        verticalArrangement = Arrangement.spacedBy(7.dp)
    ) {
        AsyncImage(
            model = ImageRequest.Builder(context)
                .data(imageUrl)
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
        Text(
            text = price,
            modifier = Modifier.padding(horizontal = 16.dp),
            maxLines = 1,
            style = MaterialTheme.typography.bodyLarge,
            color = Color.Black
        )
        Spacer(modifier = Modifier.height(8.dp))

    }
}
