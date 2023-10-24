package com.harc.ecommersappmvvm.presentaion.screens.auth.login.components

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.harc.ecommersappmvvm.R
import com.harc.ecommersappmvvm.presentaion.components.DefaultButtom
import com.harc.ecommersappmvvm.presentaion.components.DefaultTextField
import com.harc.ecommersappmvvm.presentaion.navigation.screen.auth.AuthSreen
import com.harc.ecommersappmvvm.presentaion.screens.auth.login.LoginViewModel
import com.harc.ecommersappmvvm.presentaion.ui.theme.Blue700

@Composable
fun LoginContent(navController: NavHostController, paddingValues: PaddingValues, vm:LoginViewModel = hiltViewModel()){

    val state = vm.state
    val context = LocalContext.current

    LaunchedEffect(key1 = vm.errorMesaje){
        if (vm.errorMesaje != ""){
            Toast.makeText(context , vm.errorMesaje, Toast.LENGTH_LONG).show()
            vm.errorMesaje = ""

        }
    }


    Box(modifier = Modifier
        .padding(paddingValues = paddingValues)
        .fillMaxSize()){
        Image(modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.banner) ,
            contentDescription ="Imagen de fondo",
            contentScale = ContentScale.Crop,
            colorFilter = ColorFilter.colorMatrix(ColorMatrix().apply {
                setToScale(redScale = 0.5f, 0.5f, 0.5f, 1f)
            }))
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(top = 50.dp),
            horizontalAlignment = Alignment.CenterHorizontally) {
            Image(painter = painterResource(id = R.drawable.shopping_cart_blue) ,
                modifier = Modifier
                    .height(100.dp)
                    .width(100.dp),
                contentDescription = "Imagen de logo")
            Text(text = "ECOMMERCE APP",
                modifier = Modifier.padding(top = 7.dp),
                fontWeight = FontWeight.Bold,
                color = Color.White,
                fontSize = 20.sp
            )
            Spacer(modifier = Modifier.weight(1f))
            Card(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
                    .fillMaxWidth()
                    .height(350.dp),
                shape = RoundedCornerShape(
                    topEnd = 40.dp,
                    topStart = 40.dp
                ),
                backgroundColor = Color.White.copy(alpha = 0.7f)

            ) {
                Column(

                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 30.dp)
                        .padding(horizontal = 30.dp),


                ) {
                    Text(
                        modifier = Modifier.padding(bottom = 20.dp),
                        text = "INGRESAR",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        color = Color.Black
                    )

                    DefaultTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = state.email,
                        onValueChange ={
                                       vm.onEmailInput(it)
                        } ,
                        label ="Correo electronico" ,
                        icon = Icons.Default.Email,
                        keyboardType = KeyboardType.Email,


                    )
                    DefaultTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = state.password,
                        onValueChange ={
                                       vm.onPasswordInput(it)
                        } ,
                        label ="Contraseña" ,
                        icon = Icons.Default.Lock,
                        keyboardType = KeyboardType.Password,
                        hideText = true
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    DefaultButtom(modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                        text ="LOGIN" ,
                        onClick = { vm.login() })
                    Spacer(modifier = Modifier.height(10.dp))
                    Row (
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(vertical = 10.dp),
                        horizontalArrangement = Arrangement.Center
                    ){
                        Text(text ="¿No tienes cuenta?")

                        Spacer(modifier = Modifier.height(5.dp))
                        Text(
                            modifier = Modifier.clickable {navController.navigate(route = AuthSreen.Register.route)
                            },
                            text = "Registrate",
                            color = Blue700
                        )

                    }

                }

            }

        }

    }
}