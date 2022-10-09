package ua.ilyadreamix.everyday.core.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import ua.ilyadreamix.everyday.core.theme.AppBlue
import ua.ilyadreamix.everyday.core.theme.AppWhite

@Composable
fun TextFieldSizedRoundedButton(
    modifier: Modifier = Modifier,
    color: Color = AppBlue,
    cornerRadius: Dp = 10.dp,
    enabled: MutableState<Boolean> = mutableStateOf(false),
    text: String,
    icon: @Composable () -> Unit = {},
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = modifier.fillMaxWidth().height(48.dp),
        enabled = !enabled.value,
        colors = ButtonDefaults.buttonColors(backgroundColor = color),
        shape = RoundedCornerShape(cornerRadius),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            icon()
            Text(text = text, color = AppWhite)
        }
    }
}