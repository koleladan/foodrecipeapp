package com.compose.foodrecipeapp.domain.usecases.get_categories

import com.compose.foodrecipeapp.core.Resource
import com.compose.foodrecipeapp.data.remote.dto.toCategories
import com.compose.foodrecipeapp.domain.model.Categories
import com.compose.foodrecipeapp.domain.repository_interface.RecipeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class GetFoodCategoriesUseCase @Inject constructor(
    private val repository: RecipeRepository
) {
    operator fun invoke(): Flow<Resource<List<Categories>>> = flow {
        try {
            emit(Resource.Loading())
            val categories = repository.getFoodCategories().map { it.toCategories() }
            emit(Resource.Success(categories))

        } catch (e: HttpException){
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))

        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection"))

        }
    }
}