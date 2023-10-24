package com.harc.ecommersappmvvm.presentaion.navigation.graph.roles


import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.harc.ecommersappmvvm.presentaion.navigation.Graph
import com.harc.ecommersappmvvm.presentaion.navigation.screen.roles.RolesScreen
import com.harc.ecommersappmvvm.presentaion.screens.admin.home.AdminHomeScreen
import com.harc.ecommersappmvvm.presentaion.screens.client.home.ClientHomeScreen
import com.harc.ecommersappmvvm.presentaion.screens.roles.RolesScreen

fun NavGraphBuilder.RolesNavGraph(navController: NavHostController){
    navigation(
        route = Graph.ROLES,
        startDestination = RolesScreen.Roles.route

    ){

        composable(route = RolesScreen.Roles.route){
            RolesScreen(navController)
        }
        composable(route = Graph.ADMIN){
            AdminHomeScreen()
        }
        composable(route = Graph.CLIENT){
            ClientHomeScreen()

        }
    }
}

