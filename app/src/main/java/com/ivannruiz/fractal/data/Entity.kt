package com.ivannruiz.fractal.data

sealed class Entity {
    data class Ship(
        val shipName: String?,
        val shipFacts: ShipSpecs?
    ) : Entity()

    data class ShipSpecs(
        val passengerCapacity: String?,
        val crew: String?,
        val inauguralDate: String?
    ): Entity()
}
