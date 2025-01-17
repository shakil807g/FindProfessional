package com.hulkdx.findprofessional.feature.authentication.signup

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hulkdx.findprofessional.core.R
import com.hulkdx.findprofessional.feature.authentication.ui.EmailTextField
import com.hulkdx.findprofessional.feature.authentication.ui.FilledButton
import com.hulkdx.findprofessional.feature.authentication.ui.PasswordTextField
import org.koin.androidx.compose.getViewModel

@Composable
@Preview
fun SignUpScreen(
    viewModel: SignUpViewModel = getViewModel(),

    ) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.onPrimary),
        verticalArrangement = Arrangement.Center,
    ) {
        EmailTextField(
            modifier = Modifier
                .statusBarsPadding(),
            value = email,
            onValueChanged = { email = it },
        )
        PasswordTextField(
            modifier = Modifier
                .padding(top = 8.dp),
            value = password,
            onValueChanged = { password = it },
        )
        SubmitButton(
            modifier = Modifier
                .padding(top = 16.dp),
            onClick = viewModel::onSubmitClicked
        )
    }
}

@Composable
private fun SubmitButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    FilledButton(
        modifier = modifier,
        text = stringResource(R.string.signUp),
        onClick = onClick,
    )
}
