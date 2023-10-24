package com.harc.ecommersappmvvm.presentaion.navigation.screen.auth

sealed class AuthSreen(val route:String){

    object  Login: AuthSreen("Login")
    object  Register: AuthSreen("Register")

}

