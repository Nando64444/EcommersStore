package com.harc.ecommersappmvvm.presentaion.screens.auth.register


import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.harc.ecommersappmvvm.presentaion.components.DefaultTopBar
import com.harc.ecommersappmvvm.presentaion.screens.auth.register.components.Register
import com.harc.ecommersappmvvm.presentaion.screens.auth.register.components.RegisterContent
import com.harc.ecommersappmvvm.presentaion.ui.theme.EcommersAppMVVMTheme

@Composable
fun RegisterScreen(navController: NavHostController){
    Scaffold(topBar = {

            DefaultTopBar(title = "Registro",
            upAvailable = true,
            navController = navController)
    }
    ) {paddingValues->
        RegisterContent(paddingValues = paddingValues)

    }
    Register(navController)
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun RegisterScrePreview() {
    EcommersAppMVVMTheme {
        RegisterScreen(rememberNavController())
    }
}