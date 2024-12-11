package com.app.facefit.ui.common

import com.app.facefit.data.response.LoginResponse

import com.app.facefit.data.response.Data

sealed interface UserState {
    data class Success(val user: Data): UserState
    object Error: UserState
    object Loading: UserState
}

//interface UserState {
//    abstract val user: Data
//}