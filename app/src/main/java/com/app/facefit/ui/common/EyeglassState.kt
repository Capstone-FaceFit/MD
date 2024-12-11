package com.app.facefit.ui.common

import com.app.facefit.data.response.EyeglassesResponseItem

sealed interface EyeglassState {
    data class Success(val eyeglass: EyeglassesResponseItem): EyeglassState
    object Error: EyeglassState
    object Loading: EyeglassState
}