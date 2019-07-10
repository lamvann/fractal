package com.ivannruiz.ncl

import android.os.Bundle
import com.ivannruiz.ncl.data.ShipsApi
import com.ivannruiz.ncl.mvp.BaseActivity
import com.ivannruiz.ncl.mvp.model.LoadShipModel
import com.ivannruiz.ncl.mvp.presenter.LoadShipPresenter
import com.ivannruiz.ncl.mvp.view.LoadShipView
import com.ivannruiz.ncl.utils.Constants.BLISS
import com.ivannruiz.ncl.utils.Constants.ESCAPE
import com.ivannruiz.ncl.utils.Constants.SKY
import com.ivannruiz.ncl.utils.addTo
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import kotlinx.android.synthetic.main.activity_main.bliss_btn as blissButton
import kotlinx.android.synthetic.main.activity_main.escape_btn as escapeButton
import kotlinx.android.synthetic.main.activity_main.response_txt as responseTxt
import kotlinx.android.synthetic.main.activity_main.sky_btn as skyButton

class LoadShipActivity : BaseActivity() {

    // TODO inject presenter w dagger
    lateinit var presenter: LoadShipPresenter

    @Inject
    lateinit var service: ShipsApi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        PresentationApp.appComponent.inject(this)

        createPresenter()
        setupListeners()
    }

    private fun createPresenter() {
        presenter = LoadShipPresenter(LoadShipView(this), LoadShipModel())
    }

    private fun setupListeners() {
        skyButton.setOnClickListener {
            service.getShipData(SKY)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({
                    // TODO can use string format to clean up code a bit
                    responseTxt.text = "shipName : ${it.shipName}\n" +
                            "shipFacts.passengerCapacity : ${it.shipFacts?.passengerCapacity.toString()}\n" +
                            "shipFacts.crew = ${it.shipFacts?.crew.toString()}\n" +
                            "shipFacts.inauguralDate = ${it.shipFacts?.inauguralDate.toString()}"
                }, { it.printStackTrace() }).addTo(autoDisposable)
        }

        blissButton.setOnClickListener {
            presenter.getShipData(BLISS).addTo(autoDisposable)
        }

        escapeButton.setOnClickListener {
            presenter.getShipData(ESCAPE).addTo(autoDisposable)
        }
    }
}
