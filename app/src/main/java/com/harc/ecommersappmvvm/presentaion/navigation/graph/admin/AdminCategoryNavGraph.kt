package com.harc.ecommersappmvvm.presentaion.navigation.graph.admin


import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.harc.ecommersappmvvm.presentaion.navigation.Graph
import com.harc.ecommersappmvvm.presentaion.navigation.screen.admin.AdminCategoryScreen
import com.harc.ecommersappmvvm.presentaion.navigation.screen.roles.RolesScreen
import com.harc.ecommersappmvvm.presentaion.screens.admin.category.create.AdminCategoryCreateScreen
import com.harc.ecommersappmvvm.presentaion.screens.admin.home.AdminHomeScreen
import com.harc.ecommersappmvvm.presentaion.screens.client.home.ClientHomeScreen
import com.harc.ecommersappmvvm.presentaion.screens.roles.RolesScreen

fun NavGraphBuilder.AdminCategoryNavGraph(navController: NavHostController){
    navigation(
        route = Graph.ADMIN_CATEGORY,
        startDestination = AdminCategoryScreen.CategoryCreate.route

    ){

        composable(route = AdminCategoryScreen.CategoryCreate.route){
            AdminCategoryCreateScreen(navController)
        }
    }
}

