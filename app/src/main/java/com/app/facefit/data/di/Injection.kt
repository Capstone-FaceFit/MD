package com.app.facefit.data.di

import android.content.Context
import com.app.facefit.data.EyeglassRepository
import com.app.facefit.data.preferences.UserPreferences
import com.app.facefit.data.preferences.dataStore
import com.app.facefit.data.retrofit.ApiConfig
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking

object Injection {
    fun provideRepository(context: Context): EyeglassRepository = runBlocking {
        val pref = UserPreferences.getInstance(context.dataStore)
        val user = pref.getLoginToken().first()
        ApiConfig.setAuthToken(user)
        val apiService = ApiConfig.getApiService()
        EyeglassRepository.getInstance(apiService, pref)
    }
}