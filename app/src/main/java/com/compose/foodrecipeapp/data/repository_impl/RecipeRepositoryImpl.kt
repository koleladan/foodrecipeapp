package com.compose.foodrecipeapp.data.repository_impl

import com.compose.foodrecipeapp.data.remote.TheMealApi
import com.compose.foodrecipeapp.data.remote.dto.CategoriesDto
import com.compose.foodrecipeapp.data.remote.dto.MealsDto
import com.compose.foodrecipeapp.data.remote.dto.RecipeDto
import com.compose.foodrecipeapp.domain.repository_interface.RecipeRepository
import javax.inject.Inject

class RecipeRepositoryImpl @Inject constructor(
    private val api: TheMealApi
): RecipeRepository {
    override suspend fun getFoodCategories(): List<CategoriesDto> {
        return api.getFoodCategories()
    }

    override suspend fun getMeals(query: String): MealsDto {
        return getMeals(query)
    }

    override suspend fun getFoodRecipe(idMeal: String): RecipeDto {
        return getFoodRecipe(idMeal)
    }
}