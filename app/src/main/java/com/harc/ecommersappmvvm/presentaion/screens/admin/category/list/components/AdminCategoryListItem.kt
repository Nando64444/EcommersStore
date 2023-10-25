package com.harc.ecommersappmvvm.presentaion.screens.admin.category.list.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.harc.ecommersappmvvm.R
import com.harc.ecommersappmvvm.domain.model.Category

@Composable
fun AdminCategoryListItem(category: Category){
   Column (Modifier.padding(start = 20.dp, end = 20.dp, top= 20.dp)
       .height(90.dp))
   {
       Row {
           AsyncImage(modifier = Modifier
               .size(70.dp)
               .clip(RoundedCornerShape(10.dp)),
               model = category.image, contentDescription ="" )
           Spacer(modifier = Modifier.width(5.dp))
           Column (
               modifier = Modifier.weight(1f)
           ){
               Text(text = category.name,
                   color = Color.Black,
                   fontSize = 17.sp)
               Spacer(modifier = Modifier.height(5.dp))
               Text(text = category.description,
                   color = Color.White,
                   fontSize = 14.sp
               )
               Spacer(Modifier.width(15.dp))
               Column (
                   verticalArrangement = Arrangement.Center
               ){
                   Image(modifier = Modifier.size(25.dp),
                       painter = painterResource(id = R.drawable.edit),
                       contentDescription = "")
                   Spacer(modifier = Modifier.height(5.dp))
                   Image(modifier = Modifier.size(25.dp),
                       painter = painterResource(id = R.drawable.edit),
                       contentDescription = "")

               }
           }
       }
       Spacer(modifier = Modifier.height(10.dp))
       Divider(
           color = Color.LightGray,
           startIndent = 30.dp
       )

   }

}