package com.ahenkye.amphibians.network

import retrofit2.http.GET

interface AmphibianApiService {

    @GET("amphibians")
    suspend fun getAmphibians(): List<Amphibians>

}