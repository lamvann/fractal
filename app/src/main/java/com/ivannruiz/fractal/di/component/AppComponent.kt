package com.ivannruiz.fractal.di.component


import android.app.Application
import com.ivannruiz.fractal.PresentationApp
import com.ivannruiz.fractal.di.module.ActivityBindingModule
import com.ivannruiz.fractal.di.module.ApiModule
import com.ivannruiz.fractal.di.module.ContractModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Component(
    modules = [
        ApiModule::class,
        ContractModule::class,
        ActivityBindingModule::class,
        AndroidSupportInjectionModule::class
    ]
)
@Singleton
interface AppComponent : AndroidInjector<PresentationApp> {
    /*
     * We will call this builder interface from our custom Application class.
     * This will set our application object to the AppComponent.
     * So inside the AppComponent the application instance is available.
     * So this application instance can be accessed by our modules
     * such as ApiModule when needed
     *
     * */
    /*
     * This is our custom Application class
     * */
    override fun inject(presentationApp: PresentationApp)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}
