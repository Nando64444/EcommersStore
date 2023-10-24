package com.harc.ecommersappmvvm.presentaion.screens.roles.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.harc.ecommersappmvvm.presentaion.screens.roles.RolesViewModel

@Composable
fun RolesContent(paddingValues: PaddingValues,navController: NavHostController, vm: RolesViewModel = hiltViewModel()) {
    val data = vm.authResponse.user

    LazyColumn(modifier = Modifier
        .padding(paddingValues = paddingValues)
        .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ){
        items(
            items = data?.roles ?: emptyList()
        ){rol ->
            
            RolesItem(rol = rol, navController = navController)


        }


    }
}
