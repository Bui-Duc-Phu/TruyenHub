package com.devphu.truyenhub.ui.navigation
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.devphu.truyenhub.ui.theme.localtionColors

@Composable
fun BottomNavigationBar(navController: NavController) {
    val items = listOf(Screen.Collection, Screen.Library, Screen.Ranking,Screen.Account)
    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route
    val color = localtionColors.current
    NavigationBar(
        containerColor = color.bottomNavbackground,
        modifier = Modifier.height(60.dp)
    ) {
        items.forEach { screen ->
            NavigationBarItem(
                icon = {
                    Icon(
                        painter = painterResource(id = screen.icon),
                        contentDescription = screen.title,
                        modifier = Modifier.size(20.dp) // Thay đổi kích thước icon
                    )
                },
                label = { Text(screen.title) },
                selected = currentRoute == screen.route,
                onClick = {
                    navController.navigate(screen.route) {
                        popUpTo(navController.graph.startDestinationId) { saveState = true }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )

        }
    }
}
