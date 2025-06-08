package com.ahenkye.amphibians.ui.screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.ahenkye.amphibians.R
import com.ahenkye.amphibians.network.Amphibians

@Composable
fun SuccessScreen(amphibians: List<Amphibians>, modifier: Modifier = Modifier) {
    LazyColumn(
        contentPadding = PaddingValues(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(items = amphibians) { amp ->
            AmphibianAppColumn(amphibianData = amp)
        }
        
    }
}

@Composable
fun LoadingScreen(modifier: Modifier = Modifier) {
    Image(
        modifier = modifier.size(200.dp),
        painter = painterResource(id = R.drawable.img_loading),
        contentDescription = stringResource(
            R.string.image_loading
        ),
    )
}

@Composable
 fun ErrorScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(R.drawable.offline),
            contentDescription = stringResource(R.string.oops_network_error),
        )
        Text(text = stringResource(R.string.oops_network_error),)
    }
    
}

@Composable
fun AmphibianAppColumn(
        amphibianData: Amphibians,
        modifier: Modifier = Modifier.Companion
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Companion.CenterHorizontally
    ) {
        AmphibianName(name = amphibianData)
        AmphibianImage(photo = amphibianData)
        AmphibianDescription(description = amphibianData)
        
    }
}

