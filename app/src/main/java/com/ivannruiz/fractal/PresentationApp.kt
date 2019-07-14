package com.ivannruiz.fractal

import com.ivannruiz.fractal.di.component.DaggerAppComponent
import dagger.android.DaggerApplication

class PresentationApp : DaggerApplication() {

    private val applicationInjector = DaggerAppComponent.builder()
        .application(this)
        .build()

    override fun applicationInjector() = applicationInjector
}