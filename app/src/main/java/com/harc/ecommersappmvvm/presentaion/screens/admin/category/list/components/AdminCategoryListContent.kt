package com.harc.ecommersappmvvm.presentaion.screens.admin.category.list.components


import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.harc.ecommersappmvvm.domain.model.Category


@Composable
fun AdminCategoryListContent(categories: List<Category>,paddingValues: PaddingValues){


    LazyColumn(
        modifier = Modifier
            .padding(paddingValues = paddingValues)
            .fillMaxWidth(),
    ) {
       items(
           items = categories
       ){category->
           AdminCategoryListItem(category = category)

       }

    }
}