package com.devphu.truyenhub.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.devphu.truyenhub.ui.theme.localtionColors

@Composable
fun MyButtonOne(
    icon: ImageVector? = null,
    textStart: String? = null,
    textEnd: String? = null,
    onClick: () -> Unit,
    colorForcus: Color = Color.LightGray,
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .clip(RoundedCornerShape(12.dp))
            .background(if (isPressed) colorForcus else Color.White)
            .border(
                1.dp,
                Color.Gray.takeIf { isPressed } ?: Color.White,
                shape = RoundedCornerShape(1.dp))
            .clickable(
                interactionSource = interactionSource,
                indication = null
            ) { onClick() }
            .padding(10.dp)
    ) {
        textStart?.let {
            Spacer(modifier = Modifier.width(8.dp)) // Tạo khoảng cách giữa icon và text
            Text(
                text = it,
                color = localtionColors.current.textPrimary,
                style = MaterialTheme.typography.titleLarge
            )
        }
        if (icon != null) {
            Icon(
                imageVector = icon,
                contentDescription = textStart ?: textEnd ?: "",
                tint = localtionColors.current.textPrimary
            )
        }
        textEnd?.let {
            Spacer(modifier = Modifier.width(8.dp)) // Tạo khoảng cách giữa icon và text
            Text(
                text = it,
                color = localtionColors.current.textPrimary,
                style = MaterialTheme.typography.titleLarge
            )
        }
    }
}

