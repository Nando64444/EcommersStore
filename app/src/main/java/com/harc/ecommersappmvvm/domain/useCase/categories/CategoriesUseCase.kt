package com.harc.ecommersappmvvm.domain.useCase.categories


data class CategoriesUseCase(
    val createCategory: CreateCategoriesUseCase,
    val getCategories: GetCategoriesUseCase,
)