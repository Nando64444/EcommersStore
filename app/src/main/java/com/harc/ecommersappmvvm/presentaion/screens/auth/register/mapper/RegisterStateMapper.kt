package com.harc.ecommersappmvvm.presentaion.screens.auth.register.mapper

import com.harc.ecommersappmvvm.domain.model.User
import com.harc.ecommersappmvvm.presentaion.screens.auth.register.RegisterState

fun RegisterState.toUser(): User {
    return User(
        name = name,
        lastName = lastName,
        email = email,
        phone = phone,
        password = password
    )

}