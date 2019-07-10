package com.ivannruiz.ncl.data

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface ShipsApi {
    @GET("{ship}")
    fun getShipData(
        @Path("ship") ship: String
    ): Observable<ShipResponse>
}