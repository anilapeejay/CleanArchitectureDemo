package com.kim.android.cleanarchitecturedemo.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kim.android.cleanarchitecturedemo.core.state.Resource
import com.kim.android.cleanarchitecturedemo.domain.repository.UserRepository
import com.kim.android.cleanarchitecturedemo.domain.usecase.GetUsersUseCase
import com.kim.android.cleanarchitecturedemo.presentation.state.UserUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val getUsersUseCase: GetUsersUseCase,
    private val repository: UserRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow(UserUiState())
    val uiState = _uiState.asStateFlow()
    init {
        refreshUsers()
        getUsers()
    }

    private fun getUsers() {
        viewModelScope.launch {
            getUsersUseCase().collect { result ->
                when (result) {
                    is Resource.Loading -> {
                        _uiState.update { it.copy(isLoading = true) }
                    }

                    is Resource.Success -> {
                        _uiState.update {
                            it.copy(
                                isLoading = false,
                                users = result.data
                            )
                        }
                    }

                    is Resource.Error -> {
                        _uiState.update { it.copy(isLoading = false, error = result.message) }
                    }

                    else -> {}
                }

            }
        }
    }

    private fun refreshUsers() {
        viewModelScope.launch {
           try {
               repository.refreshUsers()
           }catch (e : Exception){
               _uiState.update { it.copy(error = e.message ?: "API Error") }
           }

        }
    }
}