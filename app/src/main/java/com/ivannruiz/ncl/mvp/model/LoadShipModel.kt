package com.ivannruiz.ncl.mvp.model

import com.ivannruiz.ncl.utils.Constants.BASE_URL
import com.ivannruiz.ncl.data.ShipsApi
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject



class LoadShipModel
{
    val service: ShipsApi = Retrofit.Builder()
        .run {
        baseUrl(BASE_URL)
        addConverterFactory(GsonConverterFactory.create())
        addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        build()
            .run {
                create(ShipsApi::class.java)
            }
    }
}