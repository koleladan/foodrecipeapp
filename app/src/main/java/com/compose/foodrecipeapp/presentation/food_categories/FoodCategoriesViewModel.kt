package com.compose.foodrecipeapp.presentation.food_categories

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.compose.foodrecipeapp.core.Resource
import com.compose.foodrecipeapp.domain.usecases.get_categories.GetFoodCategoriesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject
@HiltViewModel
class FoodCategoriesViewModel @Inject constructor(
    private val getFoodCategoriesUseCase: GetFoodCategoriesUseCase
): ViewModel() {
    private val _state = mutableStateOf(FoodCategoriesState())
    val state: State<FoodCategoriesState> = _state


    init {
        getFoodCategories()
    }

    private fun getFoodCategories(){
        getFoodCategoriesUseCase().onEach { result ->
            when(result) {
                is Resource.Success -> {
                    _state.value = FoodCategoriesState(categories = result.data ?: emptyList())

                }
                is Resource.Error -> {
                    _state.value = FoodCategoriesState(
                        error = result.message ?: "An Unexpected error occurred")

                }
                is Resource.Loading -> {
                    _state.value = FoodCategoriesState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}