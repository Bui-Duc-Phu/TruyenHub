package com.devphu.truyenhub.ui.screen.library.component

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
import com.devphu.mycomponent.style.getScreenHeight
import com.devphu.mycomponent.style.getScreenWidth

import com.devphu.truyenhub.ui.screen.MyCollection.component.Toolbar
import com.devphu.truyenhub.ui.screen.MyCollection.page.DownloadedScreen
import com.devphu.truyenhub.ui.screen.MyCollection.page.ReadingScreen
import com.devphu.truyenhub.ui.screen.library.page.FemaleScreen
import com.devphu.truyenhub.ui.screen.library.page.MaleScreen
import kotlinx.coroutines.launch

@Composable
fun LibraryPager() {
    var selectedPage by remember { mutableStateOf(0) }
    val pagerState = rememberPagerState(pageCount = { 2 })
    val scope = rememberCoroutineScope()
    val tabTitles = listOf("Nam", " Nữ ")

    val weight = getScreenWidth()
    val height = getScreenHeight()

    Column(modifier = Modifier.fillMaxSize()) {
        // Tabs (Không bo góc, wrap content)
        Row(
            modifier = Modifier

                .padding(horizontal = weight * 0.26f)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            tabTitles.forEachIndexed { index, title ->
                Box(
                    modifier = Modifier
                        .weight(0.5f)
                        .clickable {
                            selectedPage = index
                            scope.launch { pagerState.animateScrollToPage(index) }
                        }
                        .background(
                            if (selectedPage == index) Color.Black else Color.LightGray
                        )
                        .padding(horizontal = 16.dp, vertical = 2.dp) // Wrap content với chữ
                        .wrapContentSize(),

                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = title,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Normal,
                        color = if (selectedPage == index) Color.White else Color.Black,
                    )
                }
            }
        }

        // Pager
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.fillMaxSize(),
            userScrollEnabled = false

        ) { page ->
            selectedPage = page // Cập nhật state khi vuốt ngang
            when (page) {
                0 -> MaleScreen()
                1 -> FemaleScreen()
            }
        }
    }
}
