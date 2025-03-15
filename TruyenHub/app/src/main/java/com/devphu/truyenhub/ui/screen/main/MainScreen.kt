package com.devphu.truyenhub.ui.screen.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.devphu.truyenhub.ui.navigation.AppNavGraph
import com.devphu.truyenhub.ui.navigation.BottomNavigationBar
import com.devphu.truyenhub.ui.theme.localtionColors

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val colors = localtionColors.current
    Scaffold(
        bottomBar = { BottomNavigationBar(navController) }
    ) { innerPadding ->
        Box(modifier = Modifier.background(colors.backgroup).padding(innerPadding))
        {
            AppNavGraph(navController = navController)
        }
    }
}
