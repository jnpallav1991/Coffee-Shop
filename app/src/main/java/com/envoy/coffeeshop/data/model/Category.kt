package com.envoy.coffeeshop.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Category(
    val alias: String,
    val title: String
): Parcelable