package com.harc.ecommersappmvvm.presentaion.screens.admin.category.list.components

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.harc.ecommersappmvvm.domain.util.Resource
import com.harc.ecommersappmvvm.presentaion.components.ProgressBar
import com.harc.ecommersappmvvm.presentaion.screens.admin.category.list.AdminCategoryListViewModel

@Composable
fun GetCategories(paddingValues: PaddingValues, vm: AdminCategoryListViewModel = hiltViewModel()) {

    when (val response = vm.categoriesResponse) {
        Resource.Loading -> {
            ProgressBar()
        }

        is Resource.Success -> {//
            Log.d("GetCategories", "Data: ${response.data}")
            AdminCategoryListContent(categories = response.data, paddingValues)

        }


        is Resource.Failure -> {
            Log.d("DEBUGGG", "Error: ${response.message}")
            Toast.makeText(LocalContext.current, response.message, Toast.LENGTH_LONG).show()
        }

        else -> {

            if (response != null) {
                Toast.makeText(LocalContext.current, "Hubo error desconocido", Toast.LENGTH_LONG)
                    .show()
            }
        }
    }
}