package com.loc.eticaretuygulamasi.feature.product.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "products")
data class ProductEntity(

    @PrimaryKey
    val id: Int,

    val title: String,

    val price: Double,

    val image: String
)
