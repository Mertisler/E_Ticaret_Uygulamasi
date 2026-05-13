package com.loc.eticaretuygulamasi.core.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.loc.eticaretuygulamasi.core.common.Constants

@Entity(tableName = Constants.CART_TABLE)
data class CartEntity(

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    val productId: Int,

    val title: String,

    val image: String,

    val price: Double,

    val quantity: Int
)
