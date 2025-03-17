package com.devphu.truyenhub.ui.screen.library.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.devphu.truyenhub.R

@Composable
fun Category(title: String, imageResId: Int) {
    Box(
        modifier = Modifier.padding(5.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Image(
                painter = painterResource(id = imageResId), // Truyền ảnh từ tham số
                contentDescription = title,
                modifier = Modifier
                    .width(24.dp)
                    .height(24.dp),
                colorFilter = ColorFilter.tint(Color.Black) // Đổi màu icon
            )
            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = title, // Truyền tiêu đề từ tham số
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCategory() {
    Category(title = "Thể loại", imageResId = R.drawable.theloai)
}
