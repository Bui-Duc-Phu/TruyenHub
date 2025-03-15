package com.devphu.truyenhub.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)
val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)
val button = Color(0xFF717171)
val buttonByFocus = Color(0xFF249AA0)
val bottonNavbackground = Color(0xFDFDFD)



@Immutable
data class AppColor(
    val backgroup: Color,
    val primaryColor: Color,
    val textPrimary: Color,
    val button: Color,
    val buttonByFocus: Color,
    val bottomNavbackground: Color,
    )


val localtionColors = staticCompositionLocalOf {
    AppColor(
        backgroup = Color.Unspecified,
        primaryColor = Color.Unspecified,
        textPrimary = Color.Unspecified,
        button = Color.Unspecified,
        buttonByFocus = Color.Unspecified,
        bottomNavbackground = Color.Unspecified,
    )
}

val ColorMainLight = AppColor(
    backgroup = Color.White,
    primaryColor = Color.White,
    textPrimary = Color.Black,
    button = button,
    buttonByFocus = buttonByFocus,
    bottomNavbackground = bottonNavbackground,
)


val ColorMainDark = AppColor(
    backgroup = Color.Black,
    primaryColor = Color.Blue,
    textPrimary = Color.White,
    button = button,
    buttonByFocus = buttonByFocus,
    bottomNavbackground = bottonNavbackground,
)