package com.harc.ecommersappmvvm.presentaion.screens.admin.category.list

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.harc.ecommersappmvvm.domain.model.Category
import com.harc.ecommersappmvvm.domain.useCase.categories.CategoriesUseCase
import com.harc.ecommersappmvvm.domain.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AdminCategoryListViewModel @Inject constructor(private val categoriesUseCase: CategoriesUseCase): ViewModel(){

    var categoriesResponse by mutableStateOf<Resource<List<Category>>?>(null)
        private set
    init {
        getCategories()
    }


    fun getCategories() = viewModelScope.launch {
        categoriesResponse = Resource.Loading
        categoriesUseCase.getCategories().collect(){data->
            categoriesResponse = data

        }
    }
}