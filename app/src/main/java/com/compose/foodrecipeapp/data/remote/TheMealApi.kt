package com.compose.foodrecipeapp.data.remote

import com.compose.foodrecipeapp.data.remote.dto.CategoriesDto
import com.compose.foodrecipeapp.data.remote.dto.MealsDto
import com.compose.foodrecipeapp.data.remote.dto.RecipeDto
import retrofit2.http.GET
import retrofit2.http.Query

interface TheMealApi {
    @GET("categories.php")
    suspend fun getFoodCategories(): List<CategoriesDto>

    @GET("filter.php")
    suspend fun getMeals(
        @Query("query") query: String
    ): MealsDto

    @GET("lookup.php")
    suspend fun getRecipeDetails(
        @Query("idMeal") idMeal: String
    ):RecipeDto
}