package com.ivannruiz.ncl.mvp.presenter

import android.annotation.SuppressLint
import android.widget.TextView
import com.ivannruiz.ncl.mvp.model.LoadShipModel
import com.ivannruiz.ncl.mvp.view.LoadShipView
import com.ivannruiz.ncl.utils.ActivityScope
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.internal.util.BackpressureHelper.add
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class LoadShipPresenter (
    private val view: LoadShipView,
    private val model: LoadShipModel
) {
    private val responseTxt: TextView
        get() = view.responseTxt

    init {
        view.init()
    }

    @SuppressLint("SetTextI18n")
    fun getShipData(ship: String): Disposable =
        model.service.getShipData(ship)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribe({
                        responseTxt.text = "shipName : ${it.shipName}\n" +
                                "shipFacts.passengerCapacity : ${it.shipFacts?.passengerCapacity.toString()}\n" +
                                "shipFacts.crew = ${it.shipFacts?.crew.toString()}\n" +
                                "shipFacts.inauguralDate = ${it.shipFacts?.inauguralDate.toString()}"
                    }, { it.printStackTrace() })
}