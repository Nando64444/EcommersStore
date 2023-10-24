package com.harc.ecommersappmvvm.di

import com.harc.ecommersappmvvm.domain.repository.AuthRepository
import com.harc.ecommersappmvvm.domain.repository.CategoriesRepository
import com.harc.ecommersappmvvm.domain.repository.UsersRepository
import com.harc.ecommersappmvvm.domain.useCase.auth.AuthUseCase
import com.harc.ecommersappmvvm.domain.useCase.auth.GetSessionDataUseCase
import com.harc.ecommersappmvvm.domain.useCase.auth.LoginUseCase
import com.harc.ecommersappmvvm.domain.useCase.auth.LogoutUseCase
import com.harc.ecommersappmvvm.domain.useCase.auth.RegisterUseCase
import com.harc.ecommersappmvvm.domain.useCase.auth.SaveSessionUseCase
import com.harc.ecommersappmvvm.domain.useCase.auth.UpdateSessionUseCase
import com.harc.ecommersappmvvm.domain.useCase.categories.CategoriesUseCase
import com.harc.ecommersappmvvm.domain.useCase.categories.CreateCategoriesUseCase
import com.harc.ecommersappmvvm.domain.useCase.categories.GetCategoriesUseCase
import com.harc.ecommersappmvvm.domain.useCase.user.UpdateUserUseCase
import com.harc.ecommersappmvvm.domain.useCase.user.UpdateUserWithImageUseCase
import com.harc.ecommersappmvvm.domain.useCase.user.UserUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

    @Module
    @InstallIn(SingletonComponent::class)
    object UseCaseModule{
        @Provides
        fun provideAuthUseCase(authRepository: AuthRepository) = AuthUseCase(
            login = LoginUseCase(authRepository),
            register = RegisterUseCase(authRepository),
            saveSession = SaveSessionUseCase(authRepository),
            getSessionData = GetSessionDataUseCase(authRepository),
            logoutUseCase = LogoutUseCase(authRepository),
            updateSessionUseCase = UpdateSessionUseCase(authRepository)

        )

        @Provides
        fun provideUserUseCase(usersRepository: UsersRepository) = UserUseCase(
            updateUser = UpdateUserUseCase(usersRepository),
            updateUserWithImage = UpdateUserWithImageUseCase(usersRepository)
        )
        @Provides
        fun provideCategoriesUserUseCase(categoriesRepository: CategoriesRepository) = CategoriesUseCase(
            createCategory = CreateCategoriesUseCase(categoriesRepository),
            getCategories = GetCategoriesUseCase(categoriesRepository)

        )


    }
