package com.ivannruiz.fractal.utils

import io.reactivex.disposables.Disposable

fun Disposable.addTo(autoDisposable: AutoDisposable) {
    autoDisposable.add(this)
}
