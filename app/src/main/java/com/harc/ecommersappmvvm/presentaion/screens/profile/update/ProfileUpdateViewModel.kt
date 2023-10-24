package com.harc.ecommersappmvvm.presentaion.screens.profile.update

    import android.annotation.SuppressLint
    import android.content.Context
    import androidx.compose.runtime.*
    import androidx.lifecycle.SavedStateHandle
    import androidx.lifecycle.ViewModel
    import androidx.lifecycle.viewModelScope
    import com.harc.ecommersappmvvm.domain.model.User
    import com.harc.ecommersappmvvm.domain.useCase.auth.AuthUseCase
    import com.harc.ecommerceappmvvm.presentation.util.ComposeFileProvider
    import com.harc.ecommerceappmvvm.presentation.util.ResultingActivityHandler
    import com.harc.ecommersappmvvm.domain.useCase.user.UserUseCase
    import com.harc.ecommersappmvvm.domain.util.Resource
    import com.harc.ecommersappmvvm.presentaion.screens.profile.update.mapper.toUser
    import dagger.hilt.android.lifecycle.HiltViewModel
    import dagger.hilt.android.qualifiers.ApplicationContext
    import kotlinx.coroutines.launch
    import java.io.File
    import javax.inject.Inject


    @HiltViewModel
    class ProfileUpdateViewModel @Inject
    constructor(
        private val authUseCase: AuthUseCase,
        private val savedStateHandle: SavedStateHandle,
        private val userUseCase: UserUseCase,
        @ApplicationContext private val context: Context
        ):ViewModel() {


        var state by mutableStateOf(ProfileUpdateState())

        // ARGUMENTS
        val data = savedStateHandle.get<String>("user")
        var user = User.fromJson(data!!)

        //IMAGENES
        var file: File? = null
        val resultingActivityHandler = ResultingActivityHandler()

        var updateResponse by mutableStateOf<Resource<User>?>(null)

        init {
            state = state.copy(
                name = user.name,
                lastName = user.lastName,
                phone = user.phone,
                image = user.image?: ""

            )
        }


        fun updateUserSessionData(userResponse: User) = viewModelScope.launch {
            authUseCase.updateSessionUseCase(userResponse)

        }
        fun onUpdate(){
            if (file != null){
                updateWithImage()
            }
            else{
                update()
            }
        }
        fun updateWithImage() = viewModelScope.launch {
            updateResponse = Resource.Loading
            val result = userUseCase.updateUserWithImage(user.id ?: "", state.toUser(), file!!)
            updateResponse = result
        }

        fun update() = viewModelScope.launch {
            updateResponse = Resource.Loading
            val result = userUseCase.updateUser(user.id ?: "", state.toUser())
            updateResponse = result
        }

        @SuppressLint("SuspiciousIndentation")
        fun pickImage() = viewModelScope.launch{
        val result = resultingActivityHandler.getContent("image/*")
            if (result != null) {
                file = ComposeFileProvider.createFileFromUri(context, result)
                state = state.copy(image = result.toString())
            }
        }
        fun takePhoto() = viewModelScope.launch {
            val result = resultingActivityHandler.takePicturePreview()
            if(result != null){
             state.copy(image = ComposeFileProvider.getPathFromBitmap(context, result))
                file = File(state.image)
            }
        }

        fun onNameInput(input: String){
            state = state.copy(name = input)
        }
        fun onLastNameInput(input: String){
            state = state.copy(lastName = input)
        }
        fun onImagelInput(input: String){
            state = state.copy(image = input)
        }
        fun onPhoneInput(input: String){
            state = state.copy(phone = input)
        }

    }