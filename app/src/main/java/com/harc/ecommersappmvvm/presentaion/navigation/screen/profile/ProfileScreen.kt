package com.harc.ecommersappmvvm.presentaion.navigation.screen.profile

sealed class ProfileScreen(val route:String){

    object  ProfileUpdate: ProfileScreen("profile/update")



}
