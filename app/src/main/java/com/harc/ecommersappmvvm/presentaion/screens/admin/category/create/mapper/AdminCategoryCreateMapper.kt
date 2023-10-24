package com.harc.ecommersappmvvm.presentaion.screens.admin.category.create.mapper

import com.harc.ecommersappmvvm.domain.model.Category
import com.harc.ecommersappmvvm.presentaion.screens.admin.category.create.components.AdminCategoryCreateState

fun AdminCategoryCreateState.toCategory(): Category{
    return Category(
        name = name,
        description = description
    )
}