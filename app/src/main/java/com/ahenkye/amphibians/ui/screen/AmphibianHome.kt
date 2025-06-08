package com.ahenkye.amphibians.ui.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ahenkye.amphibians.ui.screen.components.ErrorScreen
import com.ahenkye.amphibians.ui.screen.components.LoadingScreen
import com.ahenkye.amphibians.ui.screen.components.SuccessScreen

@Composable
fun AmphibianHomeScreen(state: NetworkState, modifier: Modifier) {
    
    when (state) {
        is NetworkState.Success -> SuccessScreen(state.info, modifier = modifier)
        is NetworkState.FailedToConnect -> ErrorScreen(modifier = Modifier.fillMaxSize())
        is NetworkState.StartLoading -> LoadingScreen(modifier = modifier)
    }
    
}