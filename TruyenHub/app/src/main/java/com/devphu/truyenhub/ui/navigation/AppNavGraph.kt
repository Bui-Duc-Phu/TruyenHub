package com.devphu.truyenhub.ui.navigation

import AccountScreen
import LibraryScreen
import RankingScreen
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.devphu.truyenhub.ui.screen.Collection.CollectionScreen

@Composable
fun AppNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.Library.route) {
        composable(Screen.Collection.route) { CollectionScreen(navController)}
        composable(Screen.Library.route) { LibraryScreen(navController) }
        composable(Screen.Ranking.route) { RankingScreen(navController) }
        composable(Screen.Account.route) { AccountScreen(navController) }
    }
}
