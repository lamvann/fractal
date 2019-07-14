package com.ivannruiz.fractal.di.module

import com.ivannruiz.fractal.data.ShipsApi
import com.ivannruiz.fractal.utils.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.Reusable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
object ApiModule{

    @JvmStatic
    @Provides
    @Reusable
    fun providesShipsApi(retrofit: Retrofit): ShipsApi =
            retrofit.create(ShipsApi::class.java)

    @JvmStatic
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
