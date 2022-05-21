package poot.fausto.movie.model

import poot.fausto.movie.model.MediaItem.*

data class MediaItem(
    val id: Int,
    val title: String,
    val thumb: String,
    val type: Type
){
    enum class Type {PHOTO, VIDEO}
}

fun getMedia() = (1..12).map{
    MediaItem(
        id = it,
        title = "Imagen $it",
        thumb = "https://picsum.photos/150/350/?blur=$it",
        type = if(it % 3 == 0) Type.PHOTO else Type.PHOTO
    )
}