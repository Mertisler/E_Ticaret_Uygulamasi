package com.loc.eticaretuygulamasi.core.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.loc.eticaretuygulamasi.core.database.entity.CartEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CartDao {

    @Query("SELECT * FROM cart")
    fun getCartItems(): Flow<List<CartEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCartItem(
        item: CartEntity
    )

    @Delete
    suspend fun deleteCartItem(
        item: CartEntity
    )

    @Query("DELETE FROM cart")
    suspend fun clearCart()
}