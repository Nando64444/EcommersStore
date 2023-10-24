package com.harc.ecommersappmvvm.domain.useCase.auth

import com.harc.ecommersappmvvm.domain.repository.AuthRepository

class LogoutUseCase constructor(private val repository: AuthRepository) {
        suspend operator fun invoke() = repository.logout()
    }
