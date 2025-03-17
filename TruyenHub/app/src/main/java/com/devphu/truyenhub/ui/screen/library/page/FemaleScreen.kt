package com.devphu.truyenhub.ui.screen.library.page

import AutoScrollingBanner
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.devphu.mycomponent.style.getScreenHeight
import com.devphu.mycomponent.style.getScreenWidth
import com.devphu.truyenhub.R
import com.devphu.truyenhub.ui.screen.library.component.LibraryPager
import com.devphu.truyenhub.ui.screen.library.component.ToolbarLB
import com.devphu.truyenhub.ui.theme.localtionColors

@Composable
fun FemaleScreen() {
    val weight = getScreenWidth()
    val height = getScreenHeight()
    LazyColumn(
        modifier = Modifier
            .padding(top = 10.dp)
            .fillMaxSize()
            .background(localtionColors.current.backgroup),

        verticalArrangement = Arrangement.Top
    ) {

        item {
            Box(
                modifier = Modifier
                    .height(height * 0.255f)
                    .padding(horizontal = weight *  0.06f)
            ) {
                AutoScrollingBanner(
                    images = listOf(
                        R.drawable.slide1,
                        R.drawable.side2,
                        R.drawable.slide3
                    )
                )
            }
        }



    }
}
