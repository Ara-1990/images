package com.the.marketplace.data.mapper

import com.the.marketplace.data.db.CartEntity
import com.the.marketplace.domain.model.CartModel

fun CartEntity.toDomain()=
    CartModel( id = id, name = name, image =  image)