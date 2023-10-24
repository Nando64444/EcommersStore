package com.harc.ecommersappmvvm.domain.useCase.auth

data class AuthUseCase(
    val login: LoginUseCase,
    val register: RegisterUseCase,
    val saveSession: SaveSessionUseCase,
    val getSessionData: GetSessionDataUseCase,
    val logoutUseCase: LogoutUseCase,
    val updateSessionUseCase: UpdateSessionUseCase

)
