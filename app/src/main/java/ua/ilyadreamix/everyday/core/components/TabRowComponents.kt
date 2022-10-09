package ua.ilyadreamix.everyday.core.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun TopIndicator(color: Color, modifier: Modifier = Modifier) {
    Box(
        modifier.fillMaxWidth()
            .offset(y = (-52).dp)
            .height(2.dp)
            .background(color = color)
    )
}