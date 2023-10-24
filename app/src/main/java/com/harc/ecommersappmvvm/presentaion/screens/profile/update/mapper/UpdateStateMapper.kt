package com.harc.ecommersappmvvm.presentaion.screens.profile.update.mapper

import com.harc.ecommersappmvvm.domain.model.User
import com.harc.ecommersappmvvm.presentaion.screens.profile.update.ProfileUpdateState

fun ProfileUpdateState.toUser(): User {
    return User(
        name = name,
        lastName = lastName,
        phone = phone,
        image = image
    )
}