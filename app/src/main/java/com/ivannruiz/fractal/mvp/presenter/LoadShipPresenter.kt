package com.ivannruiz.fractal.mvp.presenter

import com.ivannruiz.fractal.mvp.contract.ShipContract
import com.ivannruiz.fractal.mvp.model.LoadShipModel
import com.ivannruiz.fractal.utils.AutoDisposable
import com.ivannruiz.fractal.utils.addTo
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class LoadShipPresenter @Inject constructor (
    private val model: LoadShipModel
) : ShipContract.Presenter {

    private lateinit var view: ShipContract.View

    override fun attach(view: ShipContract.View) {
        this.view = view
    }

    override fun getShipSpecs(ship: String, autoDisposable: AutoDisposable) =
        model.service
            .getShipData(ship)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({
                view.updateText(
                    it.shipName.toString(),
                    it.shipFacts?.passengerCapacity.toString(),
                    it.shipFacts?.crew.toString(),
                    it.shipFacts?.inauguralDate.toString())
            },
                { it.printStackTrace() }
            ).addTo(autoDisposable)
}
