package com.ahenkye.amphibians

import android.app.Application
import com.ahenkye.amphibians.data.AppContainer
import com.ahenkye.amphibians.data.DefaultContainer
/* Application Entry point to access dependencies in the AppContainer */
class MainApplication: Application() {
    lateinit var appContainer: AppContainer
    override fun onCreate() {
        super.onCreate()
        appContainer = DefaultContainer()
    }
}