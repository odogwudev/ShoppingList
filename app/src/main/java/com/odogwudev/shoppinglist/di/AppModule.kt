package com.odogwudev.shoppinglist.di

import android.content.Context
import androidx.room.Room
import com.odogwudev.shoppinglist.data.local.ShoppingDao
import com.odogwudev.shoppinglist.data.local.ShoppingItemDatabase
import com.odogwudev.shoppinglist.data.remote.PixabayAPI
import com.odogwudev.shoppinglist.other.Constants.BASE_URL
import com.odogwudev.shoppinglist.other.Constants.DATABASE_NAME
import com.odogwudev.shoppinglist.repositories.DefaultShoppingRepository
import com.odogwudev.shoppinglist.repositories.ShoppingRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideShoppingItemDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(context, ShoppingItemDatabase::class.java, DATABASE_NAME).build()

    @Singleton
    @Provides
    fun provideShoppingDao(
        database: ShoppingItemDatabase
    ) = database.shoppingDao()

    @Singleton
    @Provides
    fun providesPixabayApi(): PixabayAPI{
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(PixabayAPI::class.java)
    }

    @Singleton
    @Provides
    fun provideDefaultShoppingRepository(
        dao: ShoppingDao,
        api: PixabayAPI,
    ) = DefaultShoppingRepository(dao, api) as ShoppingRepository
}