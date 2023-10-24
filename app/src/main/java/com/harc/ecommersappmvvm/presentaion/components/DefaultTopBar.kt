package com.harc.ecommersappmvvm.presentaion.components

import androidx.compose.foundation.layout.height
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController


@Composable
fun DefaultTopBar(
    title:String,
    upAvailable: Boolean = false,
    navController:NavHostController? = null,
    appBarHeight: Dp = 40.dp



){
    TopAppBar(modifier = Modifier
        .height(appBarHeight),
        contentColor = Color.Gray,

        title = {

            Text(text = title,
                fontSize = 15.sp,

            )
        },
        backgroundColor = Color.White,
        navigationIcon = {
            if(upAvailable){



            IconButton(onClick = { navController?.popBackStack() }) {
                Icon(
                    imageVector = Icons.Default.ArrowBack, contentDescription = "",
                    tint = Color.Gray
                )
            }

            }
        }
    )
}