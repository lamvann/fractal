package com.ivannruiz.ncl.data

import com.google.gson.annotations.SerializedName

// TODO remove serializedName annotations and test if call still works without them
data class ShipResponse(
    @SerializedName("shipName") val shipName: String?,
    @SerializedName("shipFacts") val shipFacts: ShipFacts?
)

data class ShipFacts(
    val passengerCapacity: String?,
    val crew: String?,
    val inauguralDate: String?
)