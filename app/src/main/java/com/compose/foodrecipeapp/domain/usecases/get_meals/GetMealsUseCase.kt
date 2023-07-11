package com.compose.foodrecipeapp.domain.usecases.get_meals

import com.compose.foodrecipeapp.core.Resource
import com.compose.foodrecipeapp.data.remote.dto.toMeals
import com.compose.foodrecipeapp.domain.model.Meals
import com.compose.foodrecipeapp.domain.repository_interface.RecipeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class GetMealsUseCase @Inject constructor(
    private val repository: RecipeRepository
) {
    operator fun invoke(query: String): Flow<Resource<Meals>> = flow {
        try {
            emit(Resource.Loading())
            val meals = repository.getMeals(query).toMeals()
            emit(Resource.Success(meals))

        } catch (e: HttpException){
            emit(Resource.Error(e.localizedMessage ?: "An error occurred"))

        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check internet connection"))

        }
    }
}