package com.harc.ecommersappmvvm.presentaion.screens.profile.update.components

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.outlined.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import coil.compose.AsyncImage
import com.harc.ecommersappmvvm.R
import com.harc.ecommersappmvvm.presentaion.components.DefaultButtom
import com.harc.ecommersappmvvm.presentaion.components.DefaultTextField
import com.harc.ecommersappmvvm.presentaion.components.DialogCapturePicture
import com.harc.ecommersappmvvm.presentaion.screens.profile.update.ProfileUpdateViewModel

@Composable
fun ProfileUpdateContent(
    paddingValues: PaddingValues,
    vm: ProfileUpdateViewModel = hiltViewModel()

) {
    val activity = LocalContext.current as? Activity
    val state = vm.state
    val stateDialog = remember {
        mutableStateOf(false)
    }
    vm.resultingActivityHandler.handle()
    DialogCapturePicture(
        state = stateDialog,
        takePhoto = { vm.takePhoto() },
        pickImage = { vm.pickImage()}

    )

    Box(
        modifier = Modifier
            .padding(paddingValues = paddingValues)
    ) {
        Spacer(modifier = Modifier.padding(top = 10.dp))
        Image(
            modifier = Modifier
                .fillMaxSize(),
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
    }
        Column(
            modifier = Modifier
                .fillMaxWidth()

        )
        {
            if (!vm.state.image.isNullOrBlank()) {
                AsyncImage(
                    modifier = Modifier
                        .padding(top = 15.dp)
                        .align(alignment = Alignment.CenterHorizontally)
                        .size(150.dp)
                        .clip(CircleShape)
                        .clickable { stateDialog.value = true }
                    ,
                    model = vm.state.image,
                    contentDescription = "",
                    contentScale = ContentScale.Crop
                )
            } else {
                Image(
                    modifier = Modifier
                        .padding(top = 15.dp)
                        .align(alignment = Alignment.CenterHorizontally)
                        .size(150.dp)
                        .clickable { stateDialog.value = true }
                        .clip(CircleShape),

                    painter = painterResource(id = R.drawable.user_image),
                    contentDescription = "Imagen de foto de perfil"
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

                    Text(
                        modifier = Modifier.padding(bottom = 20.dp),
                        text = "ACTUALIZAR",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        color = Color.Black

                    )

                    DefaultTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = state.name,
                        onValueChange = {vm.onNameInput(it)},
                        label = "Nombre",
                        icon = Icons.Outlined.Person


                    )
                    DefaultTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = state.lastName,
                        onValueChange = {vm.onLastNameInput(it)},
                        label = "Apellido",
                        icon = Icons.Outlined.Person
                    )
                    DefaultTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = state.phone,
                        onValueChange = {vm.onPhoneInput(it)},
                        label = "Teléfono",
                        icon = Icons.Default.Phone
                    )

                    Spacer(modifier = Modifier.height(40.dp))
                    DefaultButtom(
                        modifier = Modifier.fillMaxWidth(),
                        text = "Confirmar",
                        onClick = { vm.onUpdate() }
                    )

                }
            }
        }
    }








