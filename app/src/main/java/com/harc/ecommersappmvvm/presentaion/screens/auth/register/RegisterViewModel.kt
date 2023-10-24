package com.harc.ecommersappmvvm.presentaion.screens.auth.register

import android.util.Patterns
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.harc.ecommersappmvvm.domain.model.AuthResponse
import com.harc.ecommersappmvvm.domain.model.User
import com.harc.ecommersappmvvm.domain.useCase.auth.AuthUseCase
import com.harc.ecommersappmvvm.domain.util.Resource
import com.harc.ecommersappmvvm.presentaion.screens.auth.register.mapper.toUser
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(private val authUseCase: AuthUseCase) : ViewModel() {

    var state by mutableStateOf(RegisterState())
        private set
    var errorMesaje by mutableStateOf("")
    var registerResponse by mutableStateOf<Resource<AuthResponse>?>(null)
        private set
    fun saveSession(authResponse: AuthResponse) = viewModelScope.launch {
        authUseCase.saveSession(authResponse)
    }

    fun register() = viewModelScope.launch {
        if (isvalidateForm()){
            registerResponse = Resource.Loading
            val result = authUseCase.register(state.toUser())
            registerResponse = result
        }

    }

    fun onNameInput(input: String){
        state = state.copy(name = input)
    }
    fun onLastNameInput(input: String){
        state = state.copy(lastName = input)
    }
    fun onEmailInput(input: String){
        state = state.copy(email = input)
    }
    fun onPhoneInput(input: String){
        state = state.copy(phone = input)
    }
    fun onPasswordInput(input: String){
        state = state.copy(password = input)
    }
    fun onConfirmPasswordInput(input: String){
        state = state.copy(confirmPassword = input)
    }
    fun isvalidateForm():Boolean {
         if (state.name == ""){
            errorMesaje = "Ingrese Nombre"
             return false
        }
        else if (state.lastName == ""){
            errorMesaje = "Ingrese Apellido"
             return false
        }
        else if (state.email == ""){
            errorMesaje = "Ingrese un correo eléctronico"
             return false
        }
         else if (state.phone == ""){
             errorMesaje = "Ingrese un Telefono"
             return false
         }
        else if (state.password == ""){
            errorMesaje = "Ingrese una contraseña"
             return false
        }
        else if (state.confirmPassword == ""){
            errorMesaje = "Ingrese nuevamente la contraseña"
             return false
        }
        else if (!Patterns.EMAIL_ADDRESS.matcher(state.email).matches()){
            errorMesaje = "El email no es valido"
             return false
        }
        else if (state.password.length < 6){
            errorMesaje = "La contraseña debe tener al menos 6 caracteres"
             return false
        }
         else if (state.password != state.confirmPassword){
            errorMesaje = "Las contraseñas no coinciden"
             return false
        }

       return true
    }
}
