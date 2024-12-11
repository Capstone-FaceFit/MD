package com.app.facefit.ui.common

import com.app.facefit.data.response.Data
import com.app.facefit.data.response.LoginResponse

sealed interface LoginState {
    data class Success(val user: LoginResponse): LoginState
    object Error: LoginState
    object Loading: LoginState
}