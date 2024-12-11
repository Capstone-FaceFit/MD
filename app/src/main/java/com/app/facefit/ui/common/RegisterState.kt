package com.app.facefit.ui.common

import com.app.facefit.data.response.RegisterResponse

sealed interface RegisterState {
    data class Success(val user: RegisterResponse): RegisterState
    data class Error(val error: String): RegisterState
    object Loading: RegisterState
}