package com.envoy.coffeeshop.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Business(
    val businesses: List<Businesse>,
    val region: Region,
    val total: Int
):Parcelable