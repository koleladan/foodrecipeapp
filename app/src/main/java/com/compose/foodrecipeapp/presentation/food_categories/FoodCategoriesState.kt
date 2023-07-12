package com.compose.foodrecipeapp.presentation.food_categories

import com.compose.foodrecipeapp.domain.model.Categories

data class FoodCategoriesState(
    val isLoading: Boolean = false,
    val categories: List<Categories> = emptyList(),
    val error: String = ""
)
