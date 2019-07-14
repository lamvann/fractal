package com.ivannruiz.fractal.mvp.base

/*
 * Very important to establish a base expectation that all subclassing contracts must conform to
 * Notice we're not including a Model interface as sometimes, simpler screens do not make use of models
 */
class BaseContract {
    interface Presenter<in T> {
        fun attach(view: T)
    }

    interface View
}