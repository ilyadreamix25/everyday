package ua.ilyadreamix.everyday.auth.signin

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Password
import androidx.compose.material.icons.rounded.Visibility
import androidx.compose.material.icons.rounded.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import ua.ilyadreamix.everyday.R
import ua.ilyadreamix.everyday.core.components.RoundedTextField
import ua.ilyadreamix.everyday.core.components.TextFieldSizedRoundedButton

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SignInUI(
    modifier: Modifier = Modifier,
    isLoading: MutableState<Boolean> = mutableStateOf(false)
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 8.dp, end = 8.dp, top = 8.dp)
    ) {
        val email = remember { mutableStateOf("") }
        val password = remember { mutableStateOf("") }
        var passwordVisible by remember { mutableStateOf(true) }

        val (focusRequester) = FocusRequester.createRefs()
        val keyboardController = LocalSoftwareKeyboardController.current

        // Email field
        RoundedTextField(
            icon = Icons.Rounded.Email,
            label = stringResource(R.string.auth_email),
            placeholder = stringResource(R.string.auth_email_text),
            value = email,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 12.dp),
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
            keyboardActions = KeyboardActions(
                onNext = { focusRequester.requestFocus() }
            )
        )

        // Password field
        RoundedTextField(
            icon = Icons.Rounded.Password,
            label = stringResource(R.string.auth_password),
            placeholder = stringResource(R.string.auth_password_text),
            value = password,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 12.dp)
                .focusRequester(focusRequester),
            trailingIcon = {
                IconButton(
                    onClick = { passwordVisible = !passwordVisible },
                    modifier = Modifier.padding(end = 4.dp)
                ) {
                    Icon(
                        if (passwordVisible) Icons.Rounded.Visibility else Icons.Rounded.VisibilityOff,
                        null
                    )
                }
            },
            transformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
            keyboardActions = KeyboardActions(
                onDone = { keyboardController?.hide() }
            )
        )

        // Login button
        TextFieldSizedRoundedButton(
            text = stringResource(R.string.auth_signin_button),
            enabled = isLoading,
            modifier = Modifier.imePadding()
        ) {
            // Nothing
        }
    }
}