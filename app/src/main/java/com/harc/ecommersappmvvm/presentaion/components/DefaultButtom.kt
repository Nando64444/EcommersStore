package com.harc.ecommersappmvvm.presentaion.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.harc.ecommersappmvvm.presentaion.ui.theme.Blue500

@Composable
fun DefaultButtom(
    modifier: Modifier,
    text: String,
    onClick:() -> Unit,
    color: Color = Blue500,
    icon: ImageVector = Icons.Default.ArrowForward
){
    Button(modifier =
    modifier
        .fillMaxWidth(),
        onClick = {onClick()},
        colors = ButtonDefaults.buttonColors(backgroundColor = color)
    )
    {
        Icon(imageVector = icon ,
            contentDescription = "")
        Spacer(modifier = Modifier.width(10.dp))
        Text(text = text)


    }

}