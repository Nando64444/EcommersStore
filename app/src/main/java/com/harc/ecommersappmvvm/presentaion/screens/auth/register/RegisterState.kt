package com.harc.ecommersappmvvm.presentaion.screens.auth.register

data class RegisterState(
    val name: String = "",
    val lastName: String ="",
    val email: String = "",
    val phone: String = "",
    val password: String = "",
    val confirmPassword: String = ""
)
