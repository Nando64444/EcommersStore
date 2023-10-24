package com.harc.ecommersappmvvm.domain.useCase.auth

import com.harc.ecommersappmvvm.domain.model.User
import com.harc.ecommersappmvvm.domain.repository.AuthRepository

class RegisterUseCase(private val  repository: AuthRepository) {

    suspend operator fun invoke(user: User) = repository.register(user)

}