package com.ivannruiz.fractal.di.module

import com.ivannruiz.fractal.mvp.contract.ShipContract
import com.ivannruiz.fractal.mvp.presenter.LoadShipPresenter
import dagger.Binds
import dagger.Module

@Module
abstract class ContractModule {
    @Binds
    abstract fun providesPresenter(presenter: LoadShipPresenter): ShipContract.Presenter
}