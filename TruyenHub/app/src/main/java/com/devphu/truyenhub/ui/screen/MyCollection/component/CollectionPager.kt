package com.devphu.truyenhub.ui.screen.MyCollection.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

import com.devphu.truyenhub.ui.screen.MyCollection.component.Toolbar
import com.devphu.truyenhub.ui.screen.MyCollection.page.DownloadedScreen
import com.devphu.truyenhub.ui.screen.MyCollection.page.ReadingScreen
import kotlinx.coroutines.launch

@Composable
fun CollectionPager() {
    var selectedPage by remember { mutableStateOf(0) }
    val pagerState = rememberPagerState(pageCount = { 2 })
    val scope = rememberCoroutineScope()
    val tabTitles = listOf("Đang đọc", "Đã tải về")

    Column(modifier = Modifier.fillMaxSize()) {
        // Tabs
        Row(
            modifier = Modifier
                .padding(horizontal = 10.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            tabTitles.forEachIndexed { index, title ->
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .weight(1f)
                        .clickable {
                            selectedPage = index
                            scope.launch { pagerState.animateScrollToPage(index) }
                        }
                ) {
                    Text(
                        text = title,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Normal,
                        color = if (selectedPage == index) Color.Black else Color.Gray
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Box(
                        modifier = Modifier
                            .height(1.dp)
                            .fillMaxWidth()
                            .background(if (selectedPage == index) Color.Blue else Color.Transparent)
                    )
                }
            }
        }



        // Pager
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.fillMaxSize()
        ) { page ->
            selectedPage = page // Cập nhật state khi vuốt ngang
            when (page) {
                0 -> DownloadedScreen()
                1 -> ReadingScreen()
            }
        }
    }
}