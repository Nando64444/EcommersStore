package com.harc.ecommersappmvvm.presentaion.screens.admin.category.create

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.harc.ecommersappmvvm.presentaion.components.DefaultTopBar
import com.harc.ecommersappmvvm.presentaion.screens.admin.category.create.components.AdminCategoryCreateContent
import com.harc.ecommersappmvvm.presentaion.screens.admin.category.create.components.CreateCategory
import com.harc.ecommersappmvvm.presentaion.ui.theme.Blue50

@Composable
fun AdminCategoryCreateScreen(navController: NavHostController){


    Scaffold(
        topBar = {
            DefaultTopBar(
                title = "Nueva categoría",
                upAvailable = true,
                navController = navController)
        },
        backgroundColor = Blue50
    ) { paddingValues->
        AdminCategoryCreateContent(paddingValues = paddingValues)

    }
    CreateCategory()
}

