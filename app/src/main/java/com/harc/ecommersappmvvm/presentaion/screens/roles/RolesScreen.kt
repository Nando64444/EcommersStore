package com.harc.ecommersappmvvm.presentaion.screens.roles

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.harc.ecommersappmvvm.presentaion.components.DefaultTopBar
import com.harc.ecommersappmvvm.presentaion.screens.roles.components.RolesContent

@Composable
fun RolesScreen(navController: NavHostController){
    Scaffold(
        topBar = { DefaultTopBar(title = "Seleccione un rol")}
    ) { PaddingValues ->
        RolesContent(PaddingValues, navController)
    }
}