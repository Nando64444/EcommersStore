package com.harc.ecommersappmvvm.presentaion.screens.admin.category.list.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.harc.ecommersappmvvm.R
import com.harc.ecommersappmvvm.domain.model.Category

@Composable
fun AdminCategoryListItem(category: Category){

    Column (Modifier
        .padding(20.dp)
        .background(Color.White, RoundedCornerShape(10.dp))
    ) {
        Row {
            AsyncImage(
                modifier = Modifier
                    .size(100.dp)
                    .clip(RoundedCornerShape(10.dp)),
                model = category.image,
                contentDescription =""
            )
            Spacer(modifier = Modifier.width(5.dp))
            Column (
                modifier = Modifier.weight(1f)
            ){
                Text(
                    text = category.name,
                    color = Color.White,
                    fontSize = 17.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = category.description,
                    color = Color.White,
                    fontSize = 14.sp
                )
                Spacer(Modifier.width(15.dp))
                Column (
                    verticalArrangement = Arrangement.Center
                ){
                    Image(
                        modifier = Modifier.size(25.dp),
                        painter = painterResource(id = R.drawable.edit),
                        contentDescription = ""
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Icon(
                        imageVector = Icons.Default.Delete,
                        contentDescription = "Eliminar",
                        tint = Color.Red,
                        modifier = Modifier.size(25.dp)
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            color = Color.Black,
            thickness = 2.dp
        )
    }
}
