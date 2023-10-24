package com.harc.ecommersappmvvm.presentaion.navigation.screen.client

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.ui.graphics.vector.ImageVector

sealed class ClientScreen(
    val route:String,
    val tittle:String,
    val icon: ImageVector

){

    object  CategoryList: ClientScreen(
        route = "client/category/list",
        tittle = "Categorias",
        icon = Icons.Default.List
    )
    object  ProductList: ClientScreen(
        route = "client/product/list",
        tittle = "Productos",
        icon = Icons.Default.ThumbUp
    )
    object  Profile: ClientScreen(
        route = "client/profile",
        tittle = "Perfil",
        icon = Icons.Default.Person
    )
}
