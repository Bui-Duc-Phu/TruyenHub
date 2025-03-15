package com.devphu.truyenhub.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider

private val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80
)

private val LightColorScheme = lightColorScheme(
    primary = Purple40,
    secondary = PurpleGrey40,
    tertiary = Pink40
)


@Composable
fun TruyenHubTheme(
    darkTheme: Boolean,
    content: @Composable () -> Unit
) {

    val colors = if (darkTheme) ColorMainDark else ColorMainLight
    CompositionLocalProvider(localtionColors provides colors) {
        MaterialTheme(
            typography = Typography,
            content = content
        )
    }
}