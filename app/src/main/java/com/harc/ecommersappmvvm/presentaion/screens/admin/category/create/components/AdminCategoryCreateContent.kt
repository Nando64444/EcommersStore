package com.harc.ecommersappmvvm.presentaion.screens.admin.category.create.components

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
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.List
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.harc.ecommersappmvvm.R
import com.harc.ecommersappmvvm.presentaion.components.DefaultButtom
import com.harc.ecommersappmvvm.presentaion.components.DefaultTextField
import com.harc.ecommersappmvvm.presentaion.components.DialogCapturePicture
import com.harc.ecommersappmvvm.presentaion.screens.admin.category.create.AdminCategoryCreateViewModel

@Composable
fun AdminCategoryCreateContent(paddingValues: PaddingValues, vm: AdminCategoryCreateViewModel = hiltViewModel()) {
    val state = vm.state
    vm.resultingActivityHandler.handle()
    val stateDialog = remember { mutableStateOf(false) }

    DialogCapturePicture(
        state = stateDialog,
        takePhoto = { vm.takePhoto() },
        pickImage = { vm.pickImage() }
    )

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(paddingValues = paddingValues),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(20.dp))

        // Título
        Text(
            text = "Crear Nueva Categoría",
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            color = Color.White
        )

        Spacer(modifier = Modifier.height(20.dp))

        // Imagen de la Categoría
        Box(
            modifier = Modifier
                .size(300.dp)
                .clip(CircleShape)
                .clickable { stateDialog.value = true },
            contentAlignment = Alignment.Center
        ) {
            if (!vm.state.image.isNullOrBlank()) {
                AsyncImage(
                    modifier = Modifier.fillMaxSize(),
                    model = vm.state.image,
                    contentDescription = "",
                    contentScale = ContentScale.Crop
                )
            } else {
                Image(
                    modifier = Modifier.fillMaxSize(),
                    painter = painterResource(id = R.drawable.image_add),
                    contentDescription = "Imagen de Categoría"
                )
            }

            Text(
                text = "Cambiar Imagen",
                fontSize = 16.sp,
                color = Color.Gray
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        // Formulario de Creación de Categoría
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            shape = RoundedCornerShape(16.dp),
            backgroundColor = Color.White
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                DefaultTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = state.name,
                    onValueChange = { vm.onNameInput(it) },
                    label = "Nombre de la categoría",
                    icon = Icons.Outlined.List,
                    inputTextColor = Color.Black
                )

                Spacer(modifier = Modifier.height(16.dp))

                DefaultTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = state.description,
                    onValueChange = { vm.onDescriptionInput(it) },
                    label = "Descripción",
                    icon = Icons.Outlined.Info,
                    inputTextColor = Color.Black
                )

                Spacer(modifier = Modifier.height(16.dp))

                DefaultButtom(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Crear Categoría",
                    onClick = { vm.createCategory() }

                )
            }

        }
        Spacer(modifier = Modifier.height(30.dp))
        Text(fontStyle = FontStyle.Italic, text = "HARC S.A")
    }
}
