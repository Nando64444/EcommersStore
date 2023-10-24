package com.harc.ecommersappmvvm.presentaion.screens.client.home.components

import androidx.compose.material.BottomNavigation
import androidx.compose.runtime.*
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.harc.ecommersappmvvm.presentaion.navigation.screen.client.ClientScreen

@Composable
fun ClientBottomBar(navController: NavHostController){
    val screens = listOf(
        ClientScreen.ProductList,
        ClientScreen.CategoryList,
        ClientScreen.Profile,
    )
    val navBackEntry by navController.currentBackStackEntryAsState()
    val currentDetinations = navBackEntry?.destination
    val BottomBarDestionation = screens.any { it.route == currentDetinations?.route }

    if (BottomBarDestionation){
        BottomNavigation() {
            screens.forEach {screen ->
                ClientBottomBarItem(screen = screen,
                     currentDestination = currentDetinations!!,
                     navController = navController
                )

            }

        }
    }

}