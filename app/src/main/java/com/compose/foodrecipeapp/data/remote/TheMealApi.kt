package com.compose.foodrecipeapp.data.remote

import com.compose.foodrecipeapp.data.remote.dto.CategoriesDto
import retrofit2.http.GET

interface TheMealApi {
    @GET("/api/json/v1/1/categories.php")
    suspend fun getFoodCategories(): List<CategoriesDto>

   // @GET("/api/json/v1/1/list.php?i=list")
}