package com.compose.foodrecipeapp.domain.usecases.get_recipe_details

import com.compose.foodrecipeapp.core.Resource
import com.compose.foodrecipeapp.data.remote.dto.toRecipe
import com.compose.foodrecipeapp.domain.model.Recipe
import com.compose.foodrecipeapp.domain.repository_interface.RecipeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class GetRecipeDetailsUseCase @Inject constructor(
    private val repository: RecipeRepository
) {
    operator fun invoke(idMeal: String): Flow<Resource<Recipe>> = flow {
        try {
            emit(Resource.Loading())
            val recipe = repository.getFoodRecipe(idMeal).toRecipe()
            emit(Resource.Success(recipe))

        }catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An error occurred"))

        } catch (e: IOException){
            emit(Resource.Error("Couldn't reach the server. Check internet connections"))
        }
    }
}