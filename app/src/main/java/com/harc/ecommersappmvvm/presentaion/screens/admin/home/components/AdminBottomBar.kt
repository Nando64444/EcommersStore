package com.harc.ecommersappmvvm.presentaion.screens.admin.home.components

import androidx.compose.material.BottomNavigation
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.harc.ecommersappmvvm.presentaion.navigation.screen.admin.AdminScreen

@Composable
fun AdminBottomBar(navController: NavHostController){
    val screens = listOf(
        AdminScreen.ProductList,
        AdminScreen.CategoryList,
        AdminScreen.Profile,
    )
    val navBackEntry by navController.currentBackStackEntryAsState()
    val currentDetinations = navBackEntry?.destination
    val BottomBarDestionation = screens.any { it.route == currentDetinations?.route }

    if (BottomBarDestionation){
        BottomNavigation() {
            screens.forEach {screen ->
                AdminBottomBarItem(screen = screen,
                     currentDestination = currentDetinations!!,
                     navController = navController
                )

            }

        }
    }

}