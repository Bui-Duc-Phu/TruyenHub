package com.yourlibrary.components

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun MyColumn(
    modifier: Modifier = Modifier,
    padding: Dp = 8.dp,   // Padding bên trong
    margin: Dp = 0.dp,    // Margin bên ngoài
    spacing: Dp = 8.dp,   // Khoảng cách giữa các component con
    content: @Composable ColumnScope.() -> Unit
) {
    Box(modifier = Modifier.padding(margin)) { // Giả lập margin bằng cách bọc Column trong Box
        Column(
            modifier = modifier.padding(padding), // Padding bên trong
            verticalArrangement = Arrangement.spacedBy(spacing) // Khoảng cách giữa các component con
        ) {
            content()
        }
    }
}
