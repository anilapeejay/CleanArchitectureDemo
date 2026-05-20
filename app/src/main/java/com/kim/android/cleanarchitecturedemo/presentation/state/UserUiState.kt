package com.kim.android.cleanarchitecturedemo.presentation.state

import com.kim.android.cleanarchitecturedemo.domain.model.User

data class UserUiState(val isLoading: Boolean = false, val users: List<User> = emptyList(), val error: String = "")
