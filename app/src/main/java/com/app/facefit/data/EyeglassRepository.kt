package com.app.facefit.data

import com.app.facefit.data.model.Login
import com.app.facefit.data.model.Register
import com.app.facefit.data.preferences.UserPreferences
import com.app.facefit.data.response.EyeglassesResponseItem
import com.app.facefit.data.response.LoginResponse
import com.app.facefit.data.response.RegisterResponse
import com.app.facefit.data.retrofit.ApiService
import kotlinx.coroutines.flow.Flow

class EyeglassRepository(
    private val apiService: ApiService,
    private val userPreferences: UserPreferences
) {
    suspend fun getEyeglasses(): List<EyeglassesResponseItem> {
        return apiService.getEyeglasses()
    }

    suspend fun getDetail(id: Int): EyeglassesResponseItem {
        return apiService.getDetailEyeglass(id)
    }

    suspend fun login(user: Login): LoginResponse {
        return apiService.login(user)
    }

    suspend fun saveToken(token: String) {
        userPreferences.saveToken(token)
    }

    fun getSession(): Flow<String> = userPreferences.getLoginToken()

    suspend fun destroyToken() {
        userPreferences.destroyToken()
    }

    suspend fun register(user: Register): RegisterResponse {
        return apiService.register(user)
    }

    companion object {
        @Volatile
        private var instance: EyeglassRepository? = null

        fun clearInstance() {
            instance = null
        }

        fun getInstance(
            apiService: ApiService,
            userPreferences: UserPreferences
        ): EyeglassRepository =
            instance ?: synchronized(this) {
                instance ?: EyeglassRepository(apiService, userPreferences)
            }.also { instance = it }
    }
}