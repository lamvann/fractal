package com.ivannruiz.ncl.mvp.view

import android.widget.TextView
import com.ivannruiz.ncl.LoadShipActivity
import com.ivannruiz.ncl.mvp.ActivityView
import kotlinx.android.synthetic.main.activity_main.*

class LoadShipView (
    private val activity: LoadShipActivity
) : ActivityView<LoadShipActivity>(activity) {
    lateinit var responseTxt: TextView
    fun init() {
        activity.let {
            responseTxt = it.response_txt
        }
    }
}
