package com.ivannruiz.fractal.mvp.model

import com.ivannruiz.fractal.data.ShipsApi
import javax.inject.Inject

/*

Accessing the API directly from the model is bad practice as this results in a tightly coupled application,
this tutorial is only focusing on MVP and Dagger2 simple implementation. Later tutorials will show
correct use of MVP + CLEAN architecture through use cases and will discuss the role of the domain.

For now this will do.

 */
class LoadShipModel @Inject constructor(
    val service: ShipsApi
)