package com.harc.ecommersappmvvm.presentaion.screens.auth.login

import android.util.Log
import android.util.Patterns
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.harc.ecommersappmvvm.domain.model.AuthResponse
import com.harc.ecommersappmvvm.domain.util.Resource
import com.harc.ecommersappmvvm.domain.useCase.auth.AuthUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val authUseCase: AuthUseCase):ViewModel() {

    var state by mutableStateOf(LoginState())
        private set
    var errorMesaje by mutableStateOf("")

    // LOGIN RESPONSE
    var loginReponse by mutableStateOf<Resource<AuthResponse>?>(null)
        private set
    init {
        getSessionData()
    }

    fun getSessionData() = viewModelScope.launch {
        authUseCase.getSessionData().collect(){data ->
            if (!data.token.isNullOrBlank()){
                loginReponse = Resource.Success(data)
            }

        }
    }

    fun saveSession(authResponse: AuthResponse) = viewModelScope.launch {
        authUseCase.saveSession(authResponse)
    }


    fun login() = viewModelScope.launch {
       if (isValidateForm()){

           loginReponse = Resource.Loading

           val result = authUseCase.login(state.email, state.password)
           loginReponse = result
           Log.d("LoginViewModel", "Reponse: ${loginReponse}")
       }
    }

    var isValidForm by mutableStateOf(false)
        private set
    fun onEmailInput(email:String){
        state = state.copy(email = email)
    }
    fun onPasswordInput(password:String){
        state = state.copy(password = password)
    }
    fun isValidateForm():Boolean {
        if (!Patterns.EMAIL_ADDRESS.matcher(state.email).matches()) {
            errorMesaje = "El Email no es válido"
            return false

        } else if (state.password.length < 6) {
            errorMesaje = "La contraseña debe tener al menos 6 caracteres"
            return false

        }
        return true

    }

}