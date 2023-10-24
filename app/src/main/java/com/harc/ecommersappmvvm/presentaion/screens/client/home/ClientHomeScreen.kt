package com.harc.ecommersappmvvm.presentaion.screens.client.home

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.harc.ecommersappmvvm.presentaion.navigation.graph.client.ClientNavGraph
import com.harc.ecommersappmvvm.presentaion.screens.client.home.components.ClientBottomBar

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ClientHomeScreen(navController: NavHostController = rememberNavController()){
    Scaffold(
        bottomBar = { ClientBottomBar(navController = navController)}
    ) {  paddingValues->
       ClientNavGraph(navController = navController)

    }
}