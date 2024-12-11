package com.app.facefit.ui.screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.app.facefit.data.EyeglassRepository
import com.app.facefit.data.model.Login
import com.app.facefit.data.model.Register
import com.app.facefit.data.response.Data
import com.app.facefit.ui.common.LoginState
import com.app.facefit.ui.common.RegisterState
import com.app.facefit.ui.common.UserState
import kotlinx.coroutines.launch
import retrofit2.HttpException

class UserViewModel(
    private val repository: EyeglassRepository
): ViewModel() {
    var userState: LoginState by mutableStateOf(LoginState.Loading)
        private set

    var usersState: UserState by mutableStateOf(UserState.Loading)
        private set

    var newUserState: RegisterState by mutableStateOf(RegisterState.Loading)
        private set

    fun login(user: Login) {
        viewModelScope.launch {
            userState = try {
                val result = repository.login(user)
                LoginState.Success(result)
            }
            catch (e: Exception) {
                LoginState.Error
            } catch (e: HttpException) {
                LoginState.Error
            }
        }
    }

    suspend fun saveToken(token: String) = repository.saveToken(token)

    fun getToken(): LiveData<String> = repository.getSession().asLiveData()

    fun logout(navController: NavHostController) {
        viewModelScope.launch {
            repository.destroyToken()
            userState = LoginState.Loading
            navController.navigate("signin") {
                popUpTo("root") { inclusive = true }
            }
        }
    }

    fun register(user: Register) {
        viewModelScope.launch {
            newUserState = try {
                val result = repository.register(user)
                RegisterState.Success(result)
            } catch (e: Exception) {
                RegisterState.Error(e.message.toString())
            }
        }
    }
}