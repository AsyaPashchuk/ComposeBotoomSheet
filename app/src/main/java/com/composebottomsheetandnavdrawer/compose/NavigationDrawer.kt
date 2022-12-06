package com.composebottomsheetandnavdrawer.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.composebottomsheetandnavdrawer.MenuItem
import com.composebottomsheetandnavdrawer.R

@Composable
fun NavigationDrawerHeader(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(150.dp)
            .background(color = Color.LightGray),
        contentAlignment = Alignment.Center
    ) {
        Row(modifier = modifier
            .padding(start = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            CircleImage(image = painterResource(id = R.drawable.logo), contentDescription = "header image")
            Spacer(modifier = modifier.width(8.dp))
            Text(text = "Header", fontSize = 36.sp, modifier = modifier.weight(3f))
        }
    }
}

@Composable
fun DrawerBody(
    items: List<MenuItem>,
    modifier: Modifier = Modifier,
    itemTextStyle: TextStyle = TextStyle(fontSize = 16.sp),
    onItemClick: (MenuItem) -> Unit
) {
    LazyColumn(modifier) {
        items(items) { item ->
            Row(modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    onItemClick(item)
                }
                .padding(16.dp)
            ) {
                Icon(
                    imageVector = item.icon,
                    contentDescription = item.contentDescription,
                    modifier = Modifier
                        .padding(end = 8.dp),
                    tint = Color.DarkGray
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    modifier = Modifier.weight(1f),
                    style = itemTextStyle,
                    text = item.title
                )
            }
        }
    }
}