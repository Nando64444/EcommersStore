package com.harc.ecommersappmvvm.presentaion.screens.client.products.list

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
import com.harc.ecommersappmvvm.presentaion.screens.client.products.list.components.ClientProductListContent
import com.harc.ecommersappmvvm.presentaion.ui.theme.Blue50

@Composable
fun ClientCategoryListScreen(navController: NavHostController) {
    Scaffold(
        floatingActionButton = {
        FloatingActionButton(
            modifier = Modifier.padding(bottom = 60.dp),
            onClick = { navController.navigate(route = Graph.ADMIN_CATEGORY) }) {
          Icon(imageVector = Icons.Default.Add,
              contentDescription = "",
              tint = Blue50
          )
        }
    }) {paddingValues->
        ClientProductListContent(paddingValues = paddingValues)

    }
}