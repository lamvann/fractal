package com.ivannruiz.ncl.di

import android.app.Application
import com.ivannruiz.ncl.LoadShipActivity
import com.ivannruiz.ncl.PresentationApp
import dagger.Component
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ApiModule::class,
        ActivityBuilderModule::class
    ]
)
interface AppComponent : AndroidInjector<PresentationApp> {
    fun inject(application: Application)

    fun inject(loadShipActivity: LoadShipActivity)

    interface Builder{
        fun application(application: Application)

        fun build(): AppComponent
    }
 }
