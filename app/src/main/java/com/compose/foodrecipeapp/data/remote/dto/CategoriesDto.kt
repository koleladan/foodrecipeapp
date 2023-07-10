package com.compose.foodrecipeapp.data.remote.dto

import com.compose.foodrecipeapp.domain.model.Categories

data class CategoriesDto(
    val idCategory: String,
    val strCategory: String,
    val strCategoryDescription: String,
    val strCategoryThumb: String
)

fun CategoriesDto.toCategories(): Categories {
    return Categories(
        idCategory = idCategory,
        strCategory = strCategory,
        strCategoryDescription = strCategoryDescription,
        strCategoryThumb = strCategoryThumb
    )
}