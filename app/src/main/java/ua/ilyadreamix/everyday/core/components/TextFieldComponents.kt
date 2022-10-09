package ua.ilyadreamix.everyday.core.components

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import ua.ilyadreamix.everyday.core.theme.AppTransparent

@Composable
fun RoundedTextField(
    icon: ImageVector,
    label: String,
    placeholder: String,
    value: MutableState<String>,
    modifier: Modifier = Modifier,
    trailingIcon: @Composable () -> Unit = {},
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    transformation: VisualTransformation = VisualTransformation.None,
) {
    TextField(
        value = value.value,
        onValueChange = { value.value = it },
        leadingIcon = { Icon(icon, null) },
        shape = RoundedCornerShape(10.dp),
        label = { Text(label) },
        colors = TextFieldDefaults.textFieldColors(
            disabledIndicatorColor = AppTransparent,
            errorIndicatorColor = AppTransparent,
            focusedIndicatorColor = AppTransparent,
            unfocusedIndicatorColor = AppTransparent,
            cursorColor = MaterialTheme.colors.onSurface,
            errorCursorColor = MaterialTheme.colors.onSurface,
            focusedLabelColor = MaterialTheme.colors.onSurface
        ),
        placeholder = { Text(placeholder) },
        modifier = modifier,
        trailingIcon = trailingIcon,
        singleLine = true,
        visualTransformation = transformation,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions
    )
}