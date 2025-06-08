package com.ahenkye.amphibians.ui.screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.ahenkye.amphibians.MainApplication
import com.ahenkye.amphibians.data.AmphibiansRepository
import com.ahenkye.amphibians.network.Amphibians
import kotlinx.coroutines.launch
import okio.IOException

sealed interface NetworkState {
    data class Success(val info: List<Amphibians>) : NetworkState
    data object StartLoading : NetworkState
    data object FailedToConnect : NetworkState
}

class AmphibiansVieModel(private val repository: AmphibiansRepository) : ViewModel() {
     var networkState: NetworkState by mutableStateOf(NetworkState.StartLoading)
    
    init {
        getInfoFromWeb()
    }
    
    private fun getInfoFromWeb() {
        viewModelScope.launch {
            networkState = try {
                NetworkState.Success(repository.getAmphibianData())
            } catch (e: IOException) {
                NetworkState.FailedToConnect
            }
        }
        
    }
    
    companion object {
        var Factory: ViewModelProvider.Factory = viewModelFactory {
            
            initializer {
                val application = (this[APPLICATION_KEY] as MainApplication)
                val accessRepository = application.appContainer.amphibiansRepository
                AmphibiansVieModel(repository = accessRepository)
            }
            
        }
    }
    
    
}