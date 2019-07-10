package com.ivannruiz.ncl.di

import com.ivannruiz.ncl.data.ShipsApi
import com.ivannruiz.ncl.utils.Constants
import com.ivannruiz.ncl.utils.Constants.BASE_URL
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.Reusable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
object ApiModule{

    @Provides
    @Reusable
    fun providesShipsApi(retrofit: Retrofit): ShipsApi =
            retrofit.create(ShipsApi::class.java)

    @Provides
    @Reusable
    internal fun provideRetrofitInterface(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }
}
