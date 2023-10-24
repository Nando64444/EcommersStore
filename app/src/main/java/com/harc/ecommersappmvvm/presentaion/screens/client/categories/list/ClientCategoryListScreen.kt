package com.harc.ecommersappmvvm.presentaion.screens.client.categories.list

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import com.harc.ecommersappmvvm.presentaion.screens.client.categories.list.components.ClientCategoryListContent

@Composable
fun ClientProductListScreen() {
    Scaffold {paddingValues->
    ClientCategoryListContent(paddingValues = paddingValues)

    }
}