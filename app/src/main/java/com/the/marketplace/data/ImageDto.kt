package com.the.marketplace.data

data class ImageDto(
    val id: Int,
    val tags: String,
    val previewURL: String,
    val largeImageURL: String,
    val likes: Int,
    val views: Int
)
