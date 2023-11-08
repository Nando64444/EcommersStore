package com.harc.ecommersappmvvm.presentaion.screens.admin.category.list.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.harc.ecommersappmvvm.R
import com.harc.ecommersappmvvm.domain.model.Category
import com.harc.ecommersappmvvm.presentaion.navigation.screen.admin.AdminCategoryScreen
import com.harc.ecommersappmvvm.presentaion.screens.admin.category.list.AdminCategoryListViewModel

@Composable
fun AdminCategoryListItem(/*navController: NavHostController,*/ category: Category/*, vm: AdminCategoryListViewModel = hiltViewModel()*/) {
    Box(
        Modifier
            .padding(start = 10.dp, end = 10.dp, top = 15.dp)
            .border(2.dp, Color.Gray, RoundedCornerShape(10.dp))
            /*.clickable {
                navController.navigate(route = AdminCategoryScreen.ProductList.passCategory(category.toJson()))
            }*/
    ) {
        Row(
            Modifier
                .fillMaxWidth()
        ) {
            AsyncImage(
                modifier = Modifier
                    .size(70.dp)
                    .border(2.dp, Color.Gray, RoundedCornerShape(10.dp)),
                model = category.image,
                contentDescription = ""
            )
            Spacer(modifier = Modifier.width(25.dp))
            Column(
                Modifier.weight(1f)
            ) {
                Text(
                    text = category.name,
                    color = Color.Black,
                    fontSize = 17.sp
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = category.description,
                    color = Color.Gray,
                    fontSize = 14.sp
                )
            }
            Column(
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    modifier = Modifier
                        .size(30.dp)
                        .padding(end = 10.dp)
                      /*  .clickable {
                            navController.navigate(
                                route = AdminCategoryScreen.CategoryUpdate.passCategory(category.toJson())
                            )
                        }*/,
                    painter = painterResource(id = R.drawable.edit),
                    contentDescription = "Edit"
                )
                Spacer(modifier = Modifier.height(8.dp))
                Image(
                    modifier = Modifier
                        .size(30.dp)
                        .padding(end = 10.dp)
                       /* .clickable { vm.deleteCategory(category.id ?: "") }*/,
                    painter = painterResource(id = R.drawable.trash),
                    contentDescription = "Delete"
                )
            }
        }
    }
}
