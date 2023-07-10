package com.compose.foodrecipeapp.domain.repository_interface

import com.compose.foodrecipeapp.data.remote.dto.CategoriesDto

interface CategoryRepository {
    suspend fun getFoodCategories(): List<CategoriesDto>
}