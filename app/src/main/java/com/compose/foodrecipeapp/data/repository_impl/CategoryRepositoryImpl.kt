package com.compose.foodrecipeapp.data.repository_impl

import com.compose.foodrecipeapp.data.remote.TheMealApi
import com.compose.foodrecipeapp.data.remote.dto.CategoriesDto
import com.compose.foodrecipeapp.domain.repository_interface.CategoryRepository
import javax.inject.Inject

class CategoryRepositoryImpl @Inject constructor(
    private val api: TheMealApi
): CategoryRepository {
    override suspend fun getFoodCategories(): List<CategoriesDto> {
        return api.getFoodCategories()
    }
}