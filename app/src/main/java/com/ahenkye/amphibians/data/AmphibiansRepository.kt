package com.ahenkye.amphibians.data

import com.ahenkye.amphibians.network.AmphibianApiService
import com.ahenkye.amphibians.network.Amphibians

interface AmphibiansRepository {
    suspend fun getAmphibianData(): List<Amphibians>
}

class NetworkAmphibian(private val amphibianApiService: AmphibianApiService): AmphibiansRepository{
    override suspend fun getAmphibianData(): List<Amphibians>{
    return amphibianApiService.getAmphibians()
    }
}

