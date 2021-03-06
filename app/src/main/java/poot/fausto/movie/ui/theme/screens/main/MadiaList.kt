package poot.fausto.movie.ui.theme.screens.main

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.annotation.ExperimentalCoilApi
import poot.fausto.movie.ui.theme.screens.common.Thumb
import poot.fausto.movie.model.MediaItem
import poot.fausto.movie.model.getMedia



@ExperimentalCoilApi
@ExperimentalFoundationApi
//@Preview
@Composable
fun MediaList(navController: NavHostController, modifier: Modifier = Modifier) {
    LazyVerticalGrid( //TODO Cambria por LazyRow | LazyVerticalGrid

        contentPadding = PaddingValues(2.dp),
        cells = GridCells.Adaptive(150.dp),// TODO VerticalGrid
        modifier = Modifier


    ){

        items(getMedia()){ item ->
            MediaListItem(
                item,
                navController,
                Modifier.padding(5.dp))


        }
    }
}

@ExperimentalCoilApi

@Composable
fun MediaListItem(
    item: MediaItem,
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .clickable { navController.navigate("detail/${item.id}") },
        elevation = 0.dp,
        shape = RoundedCornerShape(12.dp),
        border = BorderStroke(0.dp, Color.Blue),
        backgroundColor = MaterialTheme.colors.secondary
    ) {
    Column {
        Thumb(item)
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()

                .padding(16.dp)
        ) {
            Text( //TEXTO
                text = item.title,
                style = MaterialTheme.typography.h6,
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight.Medium, //NEGRITAS
                letterSpacing = 3.sp //SEPARA LAS LETRAS

            )
        }
     }
    }
}
//MIN: 2:00:00
@ExperimentalCoilApi
@ExperimentalFoundationApi
@Preview
@Composable
fun MediaListItemPreview() {
   // MediaList(navController)
}