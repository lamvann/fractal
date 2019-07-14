package com.ivannruiz.fractal.mvp.view

import android.annotation.SuppressLint
import android.os.Bundle
import com.ivannruiz.fractal.R
import com.ivannruiz.fractal.mvp.base.BaseActivity
import com.ivannruiz.fractal.mvp.contract.ShipContract
import com.ivannruiz.fractal.utils.Constants.BLISS
import com.ivannruiz.fractal.utils.Constants.ESCAPE
import com.ivannruiz.fractal.utils.Constants.SKY
import javax.inject.Inject
import kotlinx.android.synthetic.main.activity_main.bliss_btn as blissButton
import kotlinx.android.synthetic.main.activity_main.escape_btn as escapeButton
import kotlinx.android.synthetic.main.activity_main.response_txt as responseTxt
import kotlinx.android.synthetic.main.activity_main.sky_btn as skyButton

class LoadShipActivity : BaseActivity(), ShipContract.View {

    @Inject lateinit var presenter: ShipContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.attach(this)
        setupListeners()
    }

    override fun setupListeners() {
        skyButton.setOnClickListener {
            presenter.getShipSpecs(SKY, autoDisposable)
        }

        blissButton.setOnClickListener {
            presenter.getShipSpecs(BLISS, autoDisposable)
        }

        escapeButton.setOnClickListener {
            presenter.getShipSpecs(ESCAPE, autoDisposable)
        }
    }

    @SuppressLint("SetTextI18n")
    override fun updateText(shipName: String, capacity: String, crew: String, inauguralDate: String) {
        responseTxt.text = "shipName : $shipName\n" +
                "shipFacts.passengerCapacity : $capacity\n" +
                "shipFacts.crew = $crew\n" +
                "shipFacts.inauguralDate = $inauguralDate"
    }
}
