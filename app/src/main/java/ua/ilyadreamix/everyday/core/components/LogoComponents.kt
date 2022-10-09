package ua.ilyadreamix.everyday.core.components

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import ua.ilyadreamix.everyday.R

@Composable
fun Logo(fontSize: TextUnit, modifier: Modifier = Modifier) {
    Text(
        text = stringResource(R.string.app_name),
        fontSize = fontSize,
        fontFamily = FontFamily(Font(R.font.logo_cookie)),
        modifier = modifier,
        fontWeight = FontWeight.Bold,
        color = MaterialTheme.colors.onBackground
    )
}