package com.composebottomsheetandnavdrawer.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp

@Composable
fun CircleImage(
    modifier: Modifier = Modifier,
    image: Painter,
    contentDescription:String
) {
    Image(
        painter = image,
        contentDescription = contentDescription,
        contentScale = ContentScale.Crop,
        modifier = modifier
//                .aspectRatio(1f, matchHeightConstraintsFirst = true)
            .border(1.dp, Color.DarkGray, CircleShape)
            .clip(CircleShape)
            .size(80.dp)
            .padding(3.dp)
    )
}