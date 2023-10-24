package com.harc.ecommersappmvvm.domain.useCase.auth

import com.harc.ecommersappmvvm.domain.repository.AuthRepository

class GetSessionDataUseCase constructor(private val repository: AuthRepository) {
    operator fun invoke() = repository.getSessionData()
}