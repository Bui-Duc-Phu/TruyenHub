package com.devphu.mycomponent.component

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.yield
import kotlin.math.abs

@SuppressLint("UnrememberedMutableState")
@Composable
fun SlideShow(
    images: List<Int>,
    onItemClick: ((Int) -> Unit)? = null,
    radius: Dp = 8.dp,
    backgroundColor: Color = Color.White,
    height: Dp = 200.dp,
    width: Dp = 350.dp,
    padding: Dp = 1.dp,
    margin: Dp = 0.dp
) {
    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()
    var userScrolled by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .width(width)
            .height(height)
            .padding(margin)
            .background(backgroundColor, shape = RoundedCornerShape(radius))
    ) {
        BoxWithConstraints(
            modifier = Modifier.fillMaxSize()
        ) {
            val density = LocalDensity.current.density
            val screenWidth = constraints.maxWidth / density
            val itemWidth = screenWidth * 1f
            val contentPadding = (screenWidth - itemWidth) / 2

            LaunchedEffect(listState) {
                snapshotFlow { listState.firstVisibleItemIndex }
                    .collect {
                        userScrolled = true
                    }
            }
            LaunchedEffect(userScrolled) {
                if (userScrolled) {
                    delay(1000) // Đợi 5 giây sau khi người dùng cuộn
                    userScrolled = false
                }
            }
            LaunchedEffect(userScrolled) {
                while (!userScrolled) {
                    yield()
                    delay(1000)

                    val nextIndex = listState.firstVisibleItemIndex + 1
                    coroutineScope.launch {
                        if (nextIndex >= images.size) {
                            listState.scrollToItem(0)
                        } else {
                            listState.animateScrollToItem(nextIndex)
                        }
                    }
                }
            }

            LazyRow(
                state = listState,
                contentPadding = PaddingValues(horizontal = contentPadding.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
            ) {
                itemsIndexed(images) { index, imageRes ->
                    val itemOffset = derivedStateOf {
                        val layoutInfo = listState.layoutInfo
                        val itemInfo = layoutInfo.visibleItemsInfo.find { it.index == index }
                        itemInfo?.let {
                            val center = (it.offset + it.size / 2)
                            val distance = abs(center - layoutInfo.viewportEndOffset / 2)
                            distance.coerceAtMost(screenWidth.toInt()) / screenWidth
                        } ?: 0f
                    }
                    val scale = 1f - 0.1f * itemOffset.value
                    val alpha = 1f - 0.2f * itemOffset.value

                    Image(
                        painter = painterResource(id = imageRes),
                        contentDescription = "Image $index",
                        contentScale = ContentScale.FillBounds,
                        modifier = Modifier
                            .width(itemWidth.dp)
                            .height(height)
                            .graphicsLayer {
                                scaleX = scale
                                scaleY = scale
                                this.alpha = alpha
                            }
                            .clip(RoundedCornerShape(radius))
                            .clickable {
                                if (onItemClick != null) {
                                    onItemClick(index)
                                }
                            }
                    )
                }
            }
        }
    }
}



