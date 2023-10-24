package com.harc.ecommersappmvvm.presentaion.navigation.graph.root

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.harc.ecommersappmvvm.presentaion.navigation.Graph
import com.harc.ecommersappmvvm.presentaion.navigation.graph.auth.AuthNavGraph
import com.harc.ecommersappmvvm.presentaion.navigation.graph.roles.RolesNavGraph

@Composable
fun RootNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = Graph.ROOT,
        startDestination = Graph.AUTH
    )
    {
        AuthNavGraph(navController = navController)
        RolesNavGraph(navController = navController)

    }
}

