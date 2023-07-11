package com.compose.foodrecipeapp.domain.repository_interface

import com.compose.foodrecipeapp.data.remote.dto.CategoriesDto
import com.compose.foodrecipeapp.data.remote.dto.MealsDto
import com.compose.foodrecipeapp.data.remote.dto.RecipeDto

interface RecipeRepository {
    suspend fun getFoodCategories(): List<CategoriesDto>
    suspend fun getMeals(query: String): MealsDto
    suspend fun getFoodRecipe(idMeal: String): RecipeDto
}