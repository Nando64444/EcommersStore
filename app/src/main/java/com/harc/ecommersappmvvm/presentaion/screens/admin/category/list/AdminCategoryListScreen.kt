package com.harc.ecommersappmvvm.presentaion.screens.admin.category.list

import androidx.compose.foundation.layout.padding
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.harc.ecommersappmvvm.presentaion.navigation.Graph
import com.harc.ecommersappmvvm.presentaion.screens.admin.category.list.components.GetCategories

@Composable
fun AdminCategoryListScreen(navController: NavHostController) {
    Scaffold(

        floatingActionButton = {
        FloatingActionButton(
            modifier = Modifier.padding(end = 15.dp, bottom = 60.dp),
            onClick = { navController.navigate(route = Graph.ADMIN_CATEGORY) }) {
            Icon(imageVector = Icons.Default.Add,
                contentDescription = "",
                tint = Color.Blue,
                )

        }
    }) {paddingValues->
        GetCategories(paddingValues)

    }

}