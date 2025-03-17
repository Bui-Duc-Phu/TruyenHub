package com.devphu.truyenhub.ui.screen.library.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.vector.ImageVector
import com.devphu.mycomponent.style.getScreenHeight
import com.devphu.mycomponent.style.getScreenWidth
import com.devphu.truyenhub.R
@Composable
fun ToolbarLB() {
    val screenHeight = 0.dp
    val screenWidth = getScreenWidth()
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height((screenHeight * 0.06f).takeIf { it > 0.dp } ?: 56.dp)
    ) {
        Text(
            text = "Thư Viện",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier
                .align(Alignment.Center)
        )
        IconButton(
            onClick = { /* TODO: Xử lý tìm kiếm */ },
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(end = (screenWidth * 0.03f).takeIf { it > 0.dp } ?: 14.dp)
        ) {
            Icon(
                // Replace ic_search with your actual drawable resource name
                imageVector = ImageVector.vectorResource(id = R.drawable.search_icon),
                contentDescription = "Search",
                tint = Color.Black,
                modifier = Modifier.size((screenWidth * 0.07f).takeIf { it > 0.dp } ?:25.dp)
            )
        }
    }
}
