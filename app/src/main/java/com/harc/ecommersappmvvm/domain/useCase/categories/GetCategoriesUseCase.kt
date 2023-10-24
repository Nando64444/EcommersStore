package com.harc.ecommersappmvvm.domain.useCase.categories

import com.harc.ecommersappmvvm.domain.model.Category
import com.harc.ecommersappmvvm.domain.repository.CategoriesRepository
import java.io.File

class GetCategoriesUseCase(private val repository: CategoriesRepository){
    suspend operator fun invoke() = repository.getCategories()
}
