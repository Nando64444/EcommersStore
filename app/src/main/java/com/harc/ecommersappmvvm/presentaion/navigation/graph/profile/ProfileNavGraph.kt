package com.harc.ecommersappmvvm.presentaion.navigation.graph.profile


import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.harc.ecommersappmvvm.presentaion.navigation.Graph
import com.harc.ecommersappmvvm.presentaion.navigation.screen.profile.ProfileScreen
import com.harc.ecommersappmvvm.presentaion.screens.profile.update.ProfileUpdateScreen

fun NavGraphBuilder.ProfileNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.PROFILE + "/{user}",
        startDestination = ProfileScreen.ProfileUpdate.route

    ) {

        composable(route = ProfileScreen.ProfileUpdate.route,
        arguments = listOf(navArgument("user"){
            type = NavType.StringType
        })
            ) {
            it.arguments?.getString("user")?.let {
                ProfileUpdateScreen(navController, userParam = it)
            }
        }
    }
}

