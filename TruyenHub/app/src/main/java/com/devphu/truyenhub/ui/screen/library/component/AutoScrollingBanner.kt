import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.layout.ContentScale
import com.devphu.mycomponent.style.getScreenHeight
import com.devphu.mycomponent.style.getScreenWidth

@Composable
fun AutoScrollingBanner(images: List<Int>) {
    val pagerState = rememberPagerState(pageCount = { images.size })
    val scope = rememberCoroutineScope()
    val weight = getScreenWidth()
    val height = getScreenHeight()

    // Tự động cuộn sau 3 giây
    LaunchedEffect(Unit) {
        while (true) {
            delay(3000)
            val nextPage = (pagerState.currentPage + 1) % images.size
            scope.launch {
                pagerState.animateScrollToPage(
                    page = nextPage,
                    animationSpec = tween(durationMillis = 1000) // Làm chậm animation (1 giây)
                )
            }
        }
    }

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
                .height(height * 0.23f)
                .background(Color.Transparent)
        ) { page ->
            Box(
                modifier = Modifier.fillMaxSize()
                    .padding(horizontal = 5.dp)
                ,
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = images[page]),
                    contentDescription = "Banner Image",
                    contentScale = ContentScale.FillBounds, // Giống với FIT_XY trong ImageView
                    modifier = Modifier.fillMaxSize()
                        .clip(RoundedCornerShape(16.dp))
                )
            }
        }

        // Indicator
        Row(
            modifier = Modifier
                .padding(top = 8.dp,)
                .height(20.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterHorizontally),
            verticalAlignment = Alignment.CenterVertically
        ) {
            images.forEachIndexed { index, _ ->
                Box(
                    modifier = Modifier
                        .size(if (pagerState.currentPage == index) 10.dp else 6.dp)
                        .clip(CircleShape)
                        .background(if (pagerState.currentPage == index) Color.Blue else Color.Gray)
                )
            }
        }

    }
}

