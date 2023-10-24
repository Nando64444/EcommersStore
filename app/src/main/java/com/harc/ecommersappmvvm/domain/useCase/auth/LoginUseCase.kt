package com.harc.ecommersappmvvm.domain.useCase.auth

import com.harc.ecommersappmvvm.domain.repository.AuthRepository

class LoginUseCase  (private val repository: AuthRepository) {

    suspend operator fun invoke (email: String, password:String) = repository.login(email, password)
}