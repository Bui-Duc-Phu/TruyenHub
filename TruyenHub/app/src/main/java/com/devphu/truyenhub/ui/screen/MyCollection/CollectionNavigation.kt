package com.devphu.truyenhub.ui.screen.Collection

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.devphu.truyenhub.ui.navigation.Screen


fun NavController.navigateHomeRoute(
    navOptions: NavOptions? = null
) {
    this.navigate(Screen.Collection.route, navOptions)
}

fun NavGraphBuilder.homeScreen() {
    composable(route = Screen.Collection.route) {
        val homeViewModel: HomeViewModel  = HomeViewModel()
        val isInitialized = rememberSaveable { mutableStateOf(false) }
        if (!isInitialized.value) {
            LaunchedEffect(key1 = Unit) {
            }
        }
//        HomeScreen(onEvent = homeViewModel::onEvent, homeUiState = homeViewModel.homeUiState)
    }
}