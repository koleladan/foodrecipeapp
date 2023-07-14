package com.compose.foodrecipeapp.presentation.food_categories

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.compose.foodrecipeapp.domain.model.Categories
import com.compose.foodrecipeapp.presentation.ui.theme.categoryItemBackground
import com.ramcosta.composedestinations.annotation.Destination

@OptIn(ExperimentalMaterialApi::class)
@Composable
@Destination
fun FoodCategoriesItem(
    categories: Categories,
    navController: NavController,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .background(categoryItemBackground)
            .clip(RoundedCornerShape(10)),
        elevation = 4.dp,
        onClick = {
            //Todo
        }

    ) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
        ) {
            AsyncImage(
                model = categories.strCategoryThumb,
                contentDescription = "categoryThumb",
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = categories.strCategory,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colors.onBackground,
                fontSize = 16.sp,
                modifier = Modifier.weight(1f)
            )
            Spacer(modifier = Modifier.height(1.dp))
            Text(
                text = categories.strCategoryDescription,
                fontWeight = FontWeight.Light,
                fontSize = 14.sp,
                color = MaterialTheme.colors.onBackground
            )

        }


    }

}