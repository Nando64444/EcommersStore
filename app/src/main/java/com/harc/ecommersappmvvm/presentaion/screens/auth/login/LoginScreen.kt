package com.harc.ecommersappmvvm.presentaion.screens.auth.login



import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.harc.ecommersappmvvm.presentaion.screens.auth.login.components.Login
import com.harc.ecommersappmvvm.presentaion.screens.auth.login.components.LoginContent
import com.harc.ecommersappmvvm.presentaion.ui.theme.EcommersAppMVVMTheme

@Composable
fun LoginScreen(navController: NavHostController){
  Scaffold(){
      paddingValues->
    LoginContent(navController = navController, paddingValues)
  }
  Login(navController = navController)


}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LoginScreenPreview() {
  EcommersAppMVVMTheme {
    LoginScreen(rememberNavController())
  }
}