package com.devphu.truyenhub.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Star
import com.devphu.truyenhub.R

sealed class Screen(val route: String, val title: String, val icon: Int) {
    object Collection : Screen("collection", "Tủ truyện", R.drawable.book_icon)
    object Library : Screen("library", "Thư viện",  R.drawable.home_icon)
    object Ranking : Screen("ranking", "Xếp hạng",  R.drawable.rank_icon)
    object Account : Screen("account", "Tài khoản",  R.drawable.account_icon)
}
 