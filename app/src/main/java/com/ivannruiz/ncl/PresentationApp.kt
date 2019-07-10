package com.ivannruiz.ncl

import android.app.Application
import com.ivannruiz.ncl.di.AppComponent
import com.ivannruiz.ncl.di.DaggerAppComponent
import com.ivannruiz.ncl.di.ApiModule

class PresentationApp : Application() {
    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent
            .builder()
            .apiModule(ApiModule)
            .build()

        appComponent.inject(this)
    }

    companion object {
        lateinit var appComponent: AppComponent
    }
}