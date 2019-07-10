package com.ivannruiz.ncl.mvp

import android.os.Bundle
import com.ivannruiz.ncl.utils.AutoDisposable
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

abstract class BaseActivity @Inject constructor() : DaggerAppCompatActivity() {

    // TODO inject autodisposable
    var autoDisposable = AutoDisposable()

    var isOnBackground: Boolean = false
        private set

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        autoDisposable.bindTo(this.lifecycle)
    }

    override fun onResume() {
        super.onResume()
        isOnBackground = false
    }

    override fun onPause() {
        super.onPause()
        isOnBackground = true
    }
}
