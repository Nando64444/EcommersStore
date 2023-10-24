package com.harc.ecommersappmvvm.domain.useCase.user

import com.harc.ecommersappmvvm.domain.model.User
import com.harc.ecommersappmvvm.domain.repository.UsersRepository
import java.io.File

class UpdateUserWithImageUseCase(private val repository: UsersRepository) {
    suspend operator fun invoke (id: String, user: User,
                                 file: File) = repository.updateWithIMage(id, user, file)
}