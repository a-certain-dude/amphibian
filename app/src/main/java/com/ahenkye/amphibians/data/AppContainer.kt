package com.ahenkye.amphibians.data

import com.ahenkye.amphibians.network.AmphibianApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/* Holds and provides dependencies */

interface AppContainer {
    val amphibiansRepository: AmphibiansRepository
}

class DefaultContainer : AppContainer {
    private val baseUrl = "https://android-kotlin-fun-mars-server.appspot.com"
    private val retrofit =
        Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).baseUrl(baseUrl)
            .build()
   private val retrofitService: AmphibianApiService by lazy { retrofit.create(AmphibianApiService::class.java) }
    override val amphibiansRepository:AmphibiansRepository by lazy {NetworkAmphibianRepository(amphibianApiService = retrofitService)}
}