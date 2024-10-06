package org.codeforegypt.apistasks.products

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionContext
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.compose.rememberImagePainter
import coil.request.ImageRequest
import org.codeforegypt.apistasks.R

@Composable
fun ProductsDetails(
     image: String,
     title: String,
     description: String,
     price: String

) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        val context = LocalContext.current

        AsyncImage(
            model = ImageRequest.Builder(context)
                .data(image)
                .crossfade(true)
                .build(),
            contentDescription = null,
            placeholder = painterResource(id = R.drawable.ic_launcher_background),
            contentScale = ContentScale.Fit,
            modifier = Modifier.fillMaxWidth()
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
            text = price.toString(),
            modifier = Modifier.padding(horizontal = 16.dp),
            maxLines = 1,
            style = MaterialTheme.typography.bodyLarge,
            color = Color.Black
        )
        Spacer(modifier = Modifier.height(8.dp))

    }

}
