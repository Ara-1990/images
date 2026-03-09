package com.the.marketplace.data.mapper

import com.the.marketplace.data.ImageDto
import com.the.marketplace.domain.model.Product

fun ImageDto.toProduct(): Product {
    return Product(
        id = id,
        image = largeImageURL,
        title = tags,
        likes = likes
    )
}