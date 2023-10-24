package com.harc.ecommersappmvvm.presentaion.navigation.graph.client

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.harc.ecommersappmvvm.presentaion.navigation.Graph
import com.harc.ecommersappmvvm.presentaion.navigation.graph.profile.ProfileNavGraph
import com.harc.ecommersappmvvm.presentaion.navigation.screen.client.ClientScreen
import com.harc.ecommersappmvvm.presentaion.screens.client.categories.list.ClientProductListScreen
import com.harc.ecommersappmvvm.presentaion.screens.client.products.list.ClientCategoryListScreen
import com.harc.ecommersappmvvm.presentaion.screens.profile.info.ProfileScreen

@Composable
fun ClientNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = Graph.CLIENT,
        startDestination = ClientScreen.ProductList.route
    )
    {
       composable(route = ClientScreen.ProductList.route){
           ClientProductListScreen()
       }
        composable(route = ClientScreen.CategoryList.route){
            ClientCategoryListScreen(navController)
       }
        composable(route = ClientScreen.Profile.route){
            ProfileScreen(navController)
       }
        ProfileNavGraph(navController)
       }
    }


