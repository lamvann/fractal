package com.ivannruiz.fractal.di.module

import com.ivannruiz.fractal.mvp.view.LoadShipActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {
    /*
    Binds LoadShipActivity in another module as a BaseActivity so that BaseActivity can be injected
    with the objects that its subclasses will use.

    Such as the AutoDisposable

     */
    @ContributesAndroidInjector(modules = [LoadShipActivityModule::class])
    abstract fun bindLoadShipActivity(): LoadShipActivity
}
