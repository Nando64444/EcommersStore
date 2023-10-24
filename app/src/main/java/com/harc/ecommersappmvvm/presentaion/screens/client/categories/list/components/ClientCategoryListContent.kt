package com.harc.ecommersappmvvm.presentaion.screens.client.categories.list.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ClientCategoryListContent(paddingValues: PaddingValues){
    Text(modifier = Modifier.padding(paddingValues = paddingValues),
        text = "Client Cateogory List Screen")
}