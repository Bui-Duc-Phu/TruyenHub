package com.devphu.truyenhub.ui.screen.Collection

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*

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
import com.devphu.truyenhub.ui.screen.MyCollection.component.CollectionPager
import com.devphu.truyenhub.ui.screen.MyCollection.component.Toolbar
import kotlinx.coroutines.launch

@Composable
fun CollectionScreen(navController: NavHostController) {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top
    ) {
        Toolbar()
        CollectionPager()
    }
}

