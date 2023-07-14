package com.compose.foodrecipeapp.presentation.food_categories

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.compose.foodrecipeapp.domain.model.Meals
import com.ramcosta.composedestinations.annotation.Destination

@Composable
@Destination
fun MealsItem(
    meals: Meals,
    navController: NavController,
    modifier: Modifier = Modifier

) {
    Box(
        modifier = Modifier
            .padding(8.dp)
            .width(150.dp)
            .clickable {
                //Todo
            }
    ) {
        Column {
            AsyncImage(
                model = meals.strMealThumb ,
                contentDescription = "meals Thumb",
                modifier = Modifier
                    .clip(RoundedCornerShape(15))
                    .height(150.dp)
            )
            Text(
                text = meals.strMeal,
                fontWeight = FontWeight.Light,
                fontSize = 14.sp,
                color = MaterialTheme.colors.onBackground
            )

        }

    }

}