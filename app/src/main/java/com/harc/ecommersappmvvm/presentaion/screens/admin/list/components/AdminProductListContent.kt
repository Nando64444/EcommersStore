package com.harc.ecommersappmvvm.presentaion.screens.admin.list.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun AdminProductListContent(paddingValues: PaddingValues){
    Text(modifier = Modifier.padding(paddingValues = paddingValues),
        text = "Client Product List Screen")
}