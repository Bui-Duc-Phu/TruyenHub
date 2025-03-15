package com.devphu.truyenhub.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Star
import com.devphu.truyenhub.R

sealed class Screen(val route: String, val title: String, val icon: Int) {
    object Collection : Screen("collection", "Collection", R.drawable.book_icon)
    object Library : Screen("library", "Library",  R.drawable.home_icon)
    object Ranking : Screen("ranking", "Ranking",  R.drawable.rank_icon)
    object Account : Screen("account", "Account",  R.drawable.account_icon)
}
 