package com.ahenkye.amphibians.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage

@Composable
fun AmphibianHomeScreen(
        modifier: Modifier = Modifier.Companion
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Companion.CenterHorizontally
    ) {
    
    
    }
}


@Composable
fun AmphibianName(name: String, modifier: Modifier = Modifier) {
    Text(text = name, modifier = modifier.fillMaxSize())
}

@Composable
fun AmphibianImage(modifier: Modifier = Modifier) {

}

@Composable
fun AmphibianDescription(description: String, modifier: Modifier = Modifier) {
    Text(text = description, modifier = modifier.fillMaxSize())
}

@Preview(name = "AmphibianApp")
@Composable
private fun PreviewAmphibianApp() {
    AmphibianHomeScreen()
}