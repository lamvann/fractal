package com.ivannruiz.fractal.di.module

import com.ivannruiz.fractal.mvp.base.BaseActivity
import com.ivannruiz.fractal.mvp.view.LoadShipActivity
import dagger.Binds
import dagger.Module

@Module
abstract class LoadShipActivityModule {

    @Binds
    abstract fun bindBaseActivity(activity: LoadShipActivity) : BaseActivity
}