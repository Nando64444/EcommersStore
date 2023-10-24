package com.harc.ecommersappmvvm.presentaion.navigation.graph.admin

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.harc.ecommersappmvvm.presentaion.navigation.Graph
import com.harc.ecommersappmvvm.presentaion.navigation.graph.profile.ProfileNavGraph
import com.harc.ecommersappmvvm.presentaion.navigation.screen.admin.AdminScreen
import com.harc.ecommersappmvvm.presentaion.screens.admin.category.list.AdminCategoryListScreen
import com.harc.ecommersappmvvm.presentaion.screens.admin.list.AdminProductListScreen
import com.harc.ecommersappmvvm.presentaion.screens.profile.info.ProfileScreen

@Composable
fun AdminNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = Graph.ADMIN,
        startDestination = AdminScreen.ProductList.route
    )
    {
        composable(route = AdminScreen.ProductList.route) {
            AdminProductListScreen()
        }
        composable(route = AdminScreen.CategoryList.route) {
            AdminCategoryListScreen(navController)
        }
        composable(route = AdminScreen.Profile.route) {
            ProfileScreen(navController)
        }
        ProfileNavGraph(navController)
        AdminCategoryNavGraph(navController)
    }
}


