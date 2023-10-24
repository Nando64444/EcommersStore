package com.harc.ecommersappmvvm.presentaion.navigation.screen.admin

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.ui.graphics.vector.ImageVector

sealed class AdminScreen(
    val route:String,
    val tittle:String,
    val icon: ImageVector

){

    object  CategoryList: AdminScreen(
        route = "admin/category/list",
        tittle = "Categorias",
        icon = Icons.Default.List
    )
    object  ProductList: AdminScreen(
        route = "admin/product/list",
        tittle = "Productos",
        icon = Icons.Default.ThumbUp
    )
    object  Profile: AdminScreen(
        route = "admin/profile",
        tittle = "Perfil",
        icon = Icons.Default.Person
    )



}
