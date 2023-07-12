package com.compose.foodrecipeapp.presentation.food_categories

import com.compose.foodrecipeapp.core.Resource
import com.compose.foodrecipeapp.domain.model.Meals

data class MealsState(
    val isLoading: Boolean = false,
    val meals: Meals? = null,
    val error: String = ""
)
