package com.harc.ecommersappmvvm.domain.useCase.auth

import com.harc.ecommersappmvvm.domain.model.AuthResponse
import com.harc.ecommersappmvvm.domain.repository.AuthRepository

class SaveSessionUseCase constructor(private val repository: AuthRepository) {
        suspend operator fun invoke(authResponse: AuthResponse) = repository.saveSession(authResponse)
    }
