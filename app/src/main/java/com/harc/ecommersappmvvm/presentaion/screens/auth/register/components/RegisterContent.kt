package com.harc.ecommersappmvvm.presentaion.screens.auth.register.components

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
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
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Phone
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.harc.ecommersappmvvm.R
import com.harc.ecommersappmvvm.presentaion.components.DefaultButtom
import com.harc.ecommersappmvvm.presentaion.components.DefaultTextField
import com.harc.ecommersappmvvm.presentaion.screens.auth.register.RegisterViewModel

@Composable
fun RegisterContent(paddingValues: PaddingValues, vm:RegisterViewModel = hiltViewModel()){

    val state = vm.state
    val context = LocalContext.current


    LaunchedEffect(key1 = vm.errorMesaje)
    {
        if (vm.errorMesaje != "") {
            Toast.makeText(context, vm.errorMesaje, Toast.LENGTH_LONG).show()
            vm.errorMesaje = ""
        }
    }

    Box(modifier = Modifier
        .padding(
            paddingValues =
            paddingValues
        )
        .fillMaxSize()) {
        Image(modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.banner) , 
            contentDescription ="Imagen de fondo" ,
        contentScale = ContentScale.Crop,
            colorFilter = ColorFilter.colorMatrix(ColorMatrix().apply {
                setToScale(redScale = 0.5f, 0.5f, 0.5f, 1f)
            }
            )
        )
         Column (
             modifier = Modifier.fillMaxSize(),
             horizontalAlignment = Alignment.CenterHorizontally
                 ){
             Image(modifier = Modifier
                 .height(100.dp)
                 .width(100.dp)
                 .padding(top = 20.dp),
                 painter = painterResource(id = R.drawable.user_image),
                 contentDescription ="Imagen para subir" 
             )
             Text(modifier = Modifier.padding(top = 7.dp),
                 text = "INGRESA ESTA INFORMACIÓN",
             fontWeight = FontWeight.Bold,
             fontSize = 20.sp,
             color = Color.White)
             Spacer(modifier = Modifier.weight(1f))
             Card(modifier = Modifier.fillMaxWidth(),
             shape = RoundedCornerShape(
                 topStart = 40.dp,
                 topEnd = 40.dp
             ),
                 backgroundColor = Color.White.copy(alpha = 0.8f)
             ) {
                 Column(
                     modifier = Modifier
                         .verticalScroll(rememberScrollState())
                         .padding(top = 30.dp, start = 30.dp, end = 30.dp, bottom = 30.dp)
                 ) {
                     Text(modifier = Modifier.padding(bottom = 20.dp),
                         text = "REGISTRATE",
                     fontSize = 20.sp,
                     color = Color.Black,
                         style = TextStyle(fontWeight = FontWeight.Bold)
                     )
                     DefaultTextField(
                         modifier = Modifier.fillMaxWidth(),
                         value = state.name,
                         onValueChange ={
                                        vm.onNameInput(it)
                         } ,
                         label = "Nombres"  ,
                         icon = Icons.Default.Person
                     
                     )
                     DefaultTextField(
                         modifier = Modifier.fillMaxWidth(),
                         value = state.lastName,
                         onValueChange ={
                                        vm.onLastNameInput(it)
                         } ,
                         label = "Apellidos"  ,
                         icon = Icons.Outlined.Person
                     
                     ) 
                     DefaultTextField(
                         modifier = Modifier.fillMaxWidth(),
                         value = state.email,
                         onValueChange ={
                                        vm.onEmailInput(it)
                         } ,
                         label = "Correo electronico",
                         icon = Icons.Outlined.Email,
                         keyboardType = KeyboardType.Email
                     
                     ) 
                     DefaultTextField(
                         modifier = Modifier.fillMaxWidth(),
                         value = state.phone,
                         onValueChange ={
                                        vm.onPhoneInput(it)
                         } ,
                         label = "Numero",
                         icon = Icons.Outlined.Phone,
                         keyboardType = KeyboardType.Number
                     
                     )
                     DefaultTextField(
                         modifier = Modifier.fillMaxWidth(),
                         value = state.password,
                         onValueChange ={
                                       vm.onPasswordInput(it)
                         } ,
                         label = "Contraseña",
                         icon = Icons.Outlined.Lock,
                         keyboardType = KeyboardType.Password,
                         hideText = true
                     
                     ) 
                     DefaultTextField(
                         modifier = Modifier.fillMaxWidth(),
                         value = state.confirmPassword,
                         onValueChange ={
                                        vm.onConfirmPasswordInput(it)
                         } ,
                         label = "Contraseña",
                         icon = Icons.Outlined.Lock,
                         keyboardType = KeyboardType.Password,
                         hideText = true
                     
                     )
                     Spacer(modifier = Modifier.height(15.dp))
                     DefaultButtom(modifier = Modifier
                         .fillMaxWidth()
                         .height(50.dp)
                         , text = "Confirmar", 
                         onClick = { vm.register() })
                     
                 }
                 
             }
             
         }
        
    }
    
}