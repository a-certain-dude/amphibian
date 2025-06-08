package com.ahenkye.amphibians.ui.screen.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.ahenkye.amphibians.R
import com.ahenkye.amphibians.network.Amphibians


@Composable
fun AmphibianName(name: Amphibians, modifier: Modifier = Modifier) {
    Text(text = name.name, modifier = modifier.fillMaxSize())
}

@Composable
fun AmphibianImage(photo: Amphibians, modifier: Modifier = Modifier) {
    // TODO: cardComposable 
    AsyncImage(
        model = ImageRequest.Builder(context = LocalContext.current)
            .data(photo.imgSrc)
            .crossfade(true)
            .build(),
        contentDescription = stringResource(R.string.amphibian_images),
        contentScale = ContentScale.Crop,
        placeholder = painterResource(R.drawable.img_loading)
    )
}

@Composable
fun AmphibianDescription(description: Amphibians, modifier: Modifier = Modifier) {
    Text(text = description.description, modifier = modifier.fillMaxSize())
}

