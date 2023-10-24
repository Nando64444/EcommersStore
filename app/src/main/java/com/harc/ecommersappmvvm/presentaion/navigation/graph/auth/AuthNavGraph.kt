package com.harc.ecommersappmvvm.presentaion.navigation.graph.auth


import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.harc.ecommersappmvvm.presentaion.navigation.Graph
import com.harc.ecommersappmvvm.presentaion.navigation.screen.auth.AuthSreen
import com.harc.ecommersappmvvm.presentaion.screens.auth.login.LoginScreen
import com.harc.ecommersappmvvm.presentaion.screens.auth.register.RegisterScreen

fun NavGraphBuilder.AuthNavGraph(navController: NavHostController){
    navigation(
        route = Graph.AUTH,
        startDestination = AuthSreen.Login.route

    ){
        composable(route = AuthSreen.Login.route){
            LoginScreen(navController)
        }
        composable(route = AuthSreen.Register.route){
            RegisterScreen(navController)
        }
    }
}

