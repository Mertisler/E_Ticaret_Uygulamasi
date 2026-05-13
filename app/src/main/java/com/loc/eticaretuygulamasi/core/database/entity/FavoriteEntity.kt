package com.loc.eticaretuygulamasi.core.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.loc.eticaretuygulamasi.core.common.Constants

@Entity(tableName = Constants.FAVORITE_TABLE)
data class FavoriteEntity(

    @PrimaryKey
    val productId: Int
)
