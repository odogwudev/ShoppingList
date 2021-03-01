package com.odogwudev.shoppinglist.repositories

import androidx.lifecycle.LiveData
import com.odogwudev.shoppinglist.data.local.ShoppingItem
import com.odogwudev.shoppinglist.data.remote.responses.ImageResponse
import com.odogwudev.shoppinglist.other.Resource
import retrofit2.Response

interface ShoppingRepository {

    suspend fun insertShoppingItem(shoppingItem: ShoppingItem)

    suspend fun deleteShoppingItem(shoppingItem: ShoppingItem)

    fun observeAllShoppingItems(): LiveData<List<ShoppingItem>>

    fun observeTotalPrice(): LiveData<Float>

    suspend fun searchForImage(imageQuery: String): Resource<ImageResponse>

}