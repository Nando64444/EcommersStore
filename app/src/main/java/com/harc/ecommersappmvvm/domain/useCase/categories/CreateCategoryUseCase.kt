package com.harc.ecommersappmvvm.domain.useCase.categories

import com.harc.ecommersappmvvm.domain.model.Category
import com.harc.ecommersappmvvm.domain.repository.CategoriesRepository
import java.io.File

class CreateCategoriesUseCase(private val repository: CategoriesRepository){
    suspend operator fun invoke(category: Category, file: File) = repository.create(category, file)
}
