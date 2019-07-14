package com.ivannruiz.fractal.mvp.contract

import com.ivannruiz.fractal.mvp.base.BaseContract
import com.ivannruiz.fractal.utils.AutoDisposable

interface ShipContract {
    interface View : BaseContract.View {
        fun updateText(shipName: String, capacity: String, crew: String, inauguralDate: String)

        fun setupListeners()
    }

    interface Presenter: BaseContract.Presenter<View> {
        fun getShipSpecs(ship: String, autoDisposable: AutoDisposable)
    }
}
