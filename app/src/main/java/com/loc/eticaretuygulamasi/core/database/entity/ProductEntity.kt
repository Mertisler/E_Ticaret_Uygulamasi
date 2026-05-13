package com.loc.eticaretuygulamasi.core.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.loc.eticaretuygulamasi.core.common.Constants

@Entity(tableName = Constants.PRODUCTS_TABLE)
data class ProductEntity(

    @PrimaryKey
    val id: Int,

    val title: String,

    val price: Double,

    val image: String
)
