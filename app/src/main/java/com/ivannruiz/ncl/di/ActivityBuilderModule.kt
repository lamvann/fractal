package com.ivannruiz.ncl.di

import com.ivannruiz.ncl.LoadShipActivity
import com.ivannruiz.ncl.mvp.BaseActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {

    @ContributesAndroidInjector
    abstract fun contributesLoadShipActivity(): LoadShipActivity

    @ContributesAndroidInjector
    abstract fun contributesBaseActivity(): BaseActivity
}
