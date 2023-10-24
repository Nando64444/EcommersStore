package com.harc.ecommersappmvvm.presentaion.screens.admin.list

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import com.harc.ecommersappmvvm.presentaion.screens.admin.list.components.AdminProductListContent

@Composable
fun AdminProductListScreen() {
    Scaffold {paddingValues->
        AdminProductListContent(paddingValues = paddingValues)

    }
}