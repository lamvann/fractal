package com.ivannruiz.fractal.mvp.base

import android.os.Bundle
import com.ivannruiz.fractal.utils.AutoDisposable
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

abstract class BaseActivity : DaggerAppCompatActivity() {

    @Inject lateinit var autoDisposable: AutoDisposable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        autoDisposable.bindTo(this.lifecycle)
    }
}
