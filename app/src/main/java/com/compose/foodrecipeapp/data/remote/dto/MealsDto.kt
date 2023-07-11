package com.compose.foodrecipeapp.data.remote.dto

import com.compose.foodrecipeapp.domain.model.Meals

data class MealsDto(
    val idMeal: String,
    val strMeal: String,
    val strMealThumb: String
)
fun MealsDto.toMeals(): Meals{
    return Meals(
        idMeal = idMeal,
        strMeal = strMeal,
        strMealThumb = strMealThumb
    )
}