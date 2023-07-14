package com.compose.foodrecipeapp.presentation.food_categories

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.compose.foodrecipeapp.core.Resource
import com.compose.foodrecipeapp.domain.usecases.get_meals.GetMealsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import retrofit2.http.Query
import javax.inject.Inject

@HiltViewModel
class MealsViewModel @Inject constructor(
    private val getMealsUseCase: GetMealsUseCase,
    savedStateHandle: SavedStateHandle
): ViewModel() {
    private val _state = mutableStateOf(MealsState())
    val state: State<MealsState> get() = _state

    init {

    }

    private fun getMeals(query: String) {
        getMealsUseCase(query)
            .onEach { result ->
            when(result){
                is Resource.Success -> {
                    _state.value = MealsState(meals = result.data)
                }
                is Resource.Error -> {
                    _state.value = MealsState(error = result.message ?: "An unexpected error occurred")

                }
                is Resource.Loading -> {
                    _state.value = MealsState(isLoading = true)

                }
            }
        }.launchIn(viewModelScope)
    }


}