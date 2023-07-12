package com.compose.foodrecipeapp.presentation.recipe_details

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.compose.foodrecipeapp.core.Resource
import com.compose.foodrecipeapp.core.util.Constants
import com.compose.foodrecipeapp.domain.usecases.get_recipe_details.GetRecipeDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class RecipeDetailsViewModel @Inject constructor(
    private val getRecipeDetailsUseCase: GetRecipeDetailsUseCase,
    savedStateHandle: SavedStateHandle
): ViewModel() {
    private val _state = mutableStateOf(RecipeDetailsState())
    val state: State<RecipeDetailsState> get()  = _state

    init {
        savedStateHandle.get<String>(Constants.id_meal)?.let { idMeal ->
            getRecipeDetailsUseCase(idMeal)
        }
    }

    private fun getRecipeDetails(idMeal: String) {
        getRecipeDetailsUseCase(idMeal)
            .onEach { result ->
                when(result) {
                    is Resource.Success -> {
                        _state.value = RecipeDetailsState(recipe = result.data)
                    }
                    is Resource.Error -> {
                        _state.value = RecipeDetailsState(error = result.message ?: "An unexpected error occurred")
                    }
                    is Resource.Loading -> {
                        _state.value = RecipeDetailsState(isLoading = true)
                    }
                }
            }.launchIn(viewModelScope)
    }
}