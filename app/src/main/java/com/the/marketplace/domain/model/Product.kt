package com.the.marketplace.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Product(
    val id: Int,
    val image: String,
    val title: String,
    val likes: Int
): Parcelable