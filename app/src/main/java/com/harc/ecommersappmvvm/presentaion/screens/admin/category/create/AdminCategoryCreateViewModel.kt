package com.harc.ecommersappmvvm.presentaion.screens.admin.category.create

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.harc.ecommerceappmvvm.presentation.util.ComposeFileProvider
import com.harc.ecommerceappmvvm.presentation.util.ResultingActivityHandler
import com.harc.ecommersappmvvm.domain.model.Category
import com.harc.ecommersappmvvm.domain.useCase.categories.CategoriesUseCase
import com.harc.ecommersappmvvm.domain.util.Resource
import com.harc.ecommersappmvvm.presentaion.screens.admin.category.create.components.AdminCategoryCreateState
import com.harc.ecommersappmvvm.presentaion.screens.admin.category.create.mapper.toCategory
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.launch
import java.io.File
import javax.inject.Inject

@HiltViewModel
class AdminCategoryCreateViewModel @Inject constructor(
    private val categoriesUseCase: CategoriesUseCase,
    @ApplicationContext val context: Context
    ): ViewModel() {
        var state by mutableStateOf(AdminCategoryCreateState())
            private set
    var categoryResponse by mutableStateOf <Resource<Category>?>(null)

    // IMAGENES
    var file : File? = null
    val resultingActivityHandler = ResultingActivityHandler()

    fun createCategory() = viewModelScope.launch {
    if(file != null){
        categoryResponse = Resource.Loading
        val result = categoriesUseCase.createCategory(state.toCategory(), file!!)
        categoryResponse = result
    }
    }
    @SuppressLint("SuspiciousIndentation")
    fun pickImage() = viewModelScope.launch{
        val result = resultingActivityHandler.getContent("image/*")
        if (result != null) {
            file = ComposeFileProvider.createFileFromUri(context, result)
            state = state.copy(image = result.toString())
            Log.d("AdminCategoryCreateViewModel", "Image received: ${state.image}")

        }
    }
    fun takePhoto() = viewModelScope.launch {
        val result = resultingActivityHandler.takePicturePreview()
        if(result != null){
            state.copy(image = ComposeFileProvider.getPathFromBitmap(context, result))
            file = File(state.image)
        }
    }
    fun ClearForm(){
        state.copy(
            name = "",
            description = "",
            image = ""
        )
        categoryResponse = null

    }
    fun onNameInput(input: String){
        state = state.copy(name = input)
    }
    fun onDescriptionInput(input: String){
        state = state.copy(description = input)
    }
}