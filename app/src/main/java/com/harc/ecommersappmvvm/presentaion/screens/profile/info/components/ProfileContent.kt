package com.harc.ecommersappmvvm.presentaion.screens.profile.info.components

import android.app.Activity
import android.content.Intent
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.harc.ecommersappmvvm.R
import com.harc.ecommersappmvvm.presentaion.MainActivity
import com.harc.ecommersappmvvm.presentaion.components.DefaultButtom
import com.harc.ecommersappmvvm.presentaion.navigation.Graph
import com.harc.ecommersappmvvm.presentaion.screens.profile.info.ProfileViewModel

@Composable
fun ProfileContent(paddingValues: PaddingValues, navController: NavHostController,vm: ProfileViewModel = hiltViewModel()) {
    val activity = LocalContext.current as? Activity

    Box(
        modifier = Modifier
            .padding(paddingValues = paddingValues)
            .padding(bottom = 55.dp)
    ) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(
                id = R.drawable.profile_background
            ),
            contentDescription = "Image de background donde va la foto de perfil",
            contentScale = ContentScale.Crop,
            colorFilter = ColorFilter.colorMatrix(
                ColorMatrix().apply {
                    setToScale(0.6f, 0.6f, 0.6f, 1f)
                }
            )
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
        )
        {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column()
                {
                    IconButton(
                        modifier = Modifier
                            .align(Alignment.End)
                            .padding(end = 10.dp, top = 10.dp),
                        onClick = {
                            vm.logout()
                            activity?.finish()
                            activity?.startActivity(Intent(activity, MainActivity::class.java))
                        }
                    )

                    {
                        Icon(
                            modifier = Modifier.size(45.dp),
                            imageVector = Icons.Default.ExitToApp,
                            contentDescription = "Imagen de foto de perfil",
                            tint = Color.White
                        )
                    }
                    Text(
                        modifier = Modifier
                            .align(Alignment.End)
                            .padding(end = 17.dp),
                        color = Color.White,
                        text = "Cerrar sesion",
                        fontSize = 12.sp
                    )

                }

            }
            Column(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
            )
            {
                if (!vm.user?.image.isNullOrBlank()) {
                    AsyncImage(
                        modifier = Modifier
                            .size(150.dp)
                            .clip(CircleShape),
                        model = vm.user?.image,
                        contentDescription = "",
                        contentScale = ContentScale.Crop
                    )
                } else {
                    Image(
                        modifier = Modifier
                            .size(150.dp)
                            .clip(CircleShape),

                        painter = painterResource(id = R.drawable.user_image),
                        contentDescription = "Imagen de foto de perfil"
                    )
                }
                Text(
                    modifier = Modifier
                        .padding(top = 5.dp)
                        .align(Alignment.CenterHorizontally),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    text = "${vm.user?.name} " +
                            "${vm.user?.lastName}"
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(
                    topEnd = 40.dp,
                    topStart = 40.dp
                ),
                backgroundColor = Color.White.copy(alpha = 0.7f)
            )
            {
                Column(modifier = Modifier.padding(20.dp)) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 15.dp),
                        verticalAlignment = Alignment.CenterVertically

                    ) {
                        Icon(
                            imageVector = Icons.Default.Person,
                            contentDescription = ""
                        )

                        Column(modifier = Modifier.padding(horizontal = 5.dp)) {
                            Text(
                                color = Color.Black,
                                text = "${vm.user?.name} ${vm.user?.lastName} "
                            )
                            Text(
                                text = "Nombre de usuario",
                                fontSize = 12.sp,
                                color = Color.Gray
                            )
                        }
                    }
                    Row(
                        modifier = Modifier
                            .padding(top = 15.dp)
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    )
                    {
                        Icon(
                            imageVector = Icons.Default.Email,
                            contentDescription = ""
                        )

                        Column(modifier = Modifier.padding(horizontal = 5.dp))
                        {
                            Text(
                                color = Color.Black,
                                text = vm.user?.email ?: ""

                            )
                            Text(
                                text = "Correo Electronico",
                                fontSize = 12.sp,
                                color = Color.Gray

                            )


                        }


                    }
                    Row(
                        modifier = Modifier
                            .padding(top = 15.dp)
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    )
                    {
                        Icon(
                            imageVector = Icons.Default.Phone,
                            contentDescription = ""
                        )

                        Column(modifier = Modifier.padding(horizontal = 5.dp)) {
                            Text(
                                color = Color.Black,
                                text = vm.user?.phone ?: ""
                            )
                            Text(
                                text = "Telefono",
                                fontSize = 12.sp,
                                color = Color.Gray
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(40.dp))
                    DefaultButtom(
                        modifier = Modifier.fillMaxWidth(),
                        text = "Actualizar información",
                        onClick = {
                            navController.navigate(route = "${Graph.PROFILE}/${vm.user?.toJson()}")
                        })

                }
            }
        }
    }
}





