package com.compose.foodrecipeapp.di

import com.compose.foodrecipeapp.core.util.Constants
import com.compose.foodrecipeapp.data.remote.TheMealApi
import com.compose.foodrecipeapp.data.repository_impl.CategoryRepositoryImpl
import com.compose.foodrecipeapp.domain.repository_interface.CategoryRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideTheMealApi(): TheMealApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(TheMealApi::class.java)
    }
    @Provides
    @Singleton
    fun provideCategoryRepository(api:TheMealApi):CategoryRepository {
        return CategoryRepositoryImpl(api)
    }
}