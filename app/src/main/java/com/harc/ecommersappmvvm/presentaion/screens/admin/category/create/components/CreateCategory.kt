package com.harc.ecommersappmvvm.presentaion.screens.admin.category.create.components

import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.harc.ecommersappmvvm.domain.util.Resource
import com.harc.ecommersappmvvm.presentaion.components.ProgressBar
import com.harc.ecommersappmvvm.presentaion.screens.admin.category.create.AdminCategoryCreateViewModel
import com.harc.ecommersappmvvm.presentaion.screens.profile.update.ProfileUpdateViewModel

@Composable
fun CreateCategory(vm: AdminCategoryCreateViewModel = hiltViewModel()){

    when (val response = vm.categoryResponse){
        Resource.Loading -> {
           ProgressBar()
        }
        is Resource.Success -> {//
            // 401 token
            vm.ClearForm()
            Toast.makeText(LocalContext.current, "Los datos se han actualizado correctamente",
                Toast.LENGTH_LONG).show()

        }


        is Resource.Failure ->{
            Log.d("DEBUGGG", "Error: ${response.message}")
            Toast.makeText(LocalContext.current, response.message, Toast.LENGTH_LONG).show()        }

        else -> {

            if (response != null) {
                Toast.makeText(LocalContext.current, "Hubo error desconocido", Toast.LENGTH_LONG).show()
            }
        }
        }
    }
