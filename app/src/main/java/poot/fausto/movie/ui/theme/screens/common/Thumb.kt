package poot.fausto.movie.ui.theme.screens.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayCircle
import androidx.compose.material.icons.filled.PlayCircleFilled
import androidx.compose.material.icons.filled.PlayCircleOutline
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import poot.fausto.movie.model.MediaItem

@ExperimentalCoilApi
@Composable
fun Thumb(item: MediaItem, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .height(180.dp)
            .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = rememberImagePainter(
                data = item.thumb,
            ),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        if (item.type == MediaItem.Type.VIDEO) {
            Icon(
                Icons.Default.PlayCircle,
                contentDescription = null,
                modifier = Modifier
                    .size(100.dp)
                    .align(Alignment.Center),
                tint = Color.White
            )
        }

    }
}