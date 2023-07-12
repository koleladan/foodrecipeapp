package com.compose.foodrecipeapp.presentation.recipe_details

import com.compose.foodrecipeapp.domain.model.Recipe

data class RecipeDetailsState(
    val isLoading: Boolean = false,
    val recipe: Recipe? = null,
    val error: String = ""
)
