package com.harc.ecommersappmvvm.presentaion.screens.admin.home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.harc.ecommersappmvvm.presentaion.navigation.graph.admin.AdminNavGraph
import com.harc.ecommersappmvvm.presentaion.screens.admin.home.components.AdminBottomBar

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun AdminHomeScreen(
    navController: NavHostController = rememberNavController()){
    Scaffold(
        bottomBar = {
            AdminBottomBar(navController = navController)},
    ) { paddingValues->
       AdminNavGraph(navController = navController)

    }
}