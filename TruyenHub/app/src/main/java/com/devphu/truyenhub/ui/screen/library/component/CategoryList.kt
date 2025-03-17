package com.devphu.truyenhub.ui.screen.library.component

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.devphu.truyenhub.R

@Composable
fun CategoryList() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp), // Chiều cao tùy chỉnh
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight(),
            contentAlignment = Alignment.Center
        ) {
            Category(title = "Thể loại", imageResId = R.drawable.theloai)
        }

        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight(),
            contentAlignment = Alignment.Center
        ) {
            Category(title = "Xêp Hạng", imageResId = R.drawable.theloai)
        }

        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight(),
            contentAlignment = Alignment.Center
        ) {
            Category(title ="Bộ lọc", imageResId = R.drawable.theloai)
        }

        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight(),
            contentAlignment = Alignment.Center
        ) {
            Category(title = "Thể loại", imageResId = R.drawable.theloai)
        }
    }
}
