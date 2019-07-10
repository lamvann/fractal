package com.ivannruiz.ncl.mvp


import android.content.Context
import androidx.fragment.app.FragmentManager
import java.lang.ref.WeakReference

open class ActivityView<T : BaseActivity>(activity: T) {

    private val activityRef: WeakReference<T> = WeakReference(activity)

    private val activity: T? = activityRef.get()

    val context: Context? = activity

    val fragmentManager: FragmentManager?
        get() = activity?.supportFragmentManager
}
