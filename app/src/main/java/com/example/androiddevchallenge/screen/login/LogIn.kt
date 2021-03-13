/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.screen.login

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
fun LogIn(onTapLogin: () -> Unit = {}) {
    Surface(
        color = MaterialTheme.colors.background,
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(horizontal = 16.dp),
        ) {
            Text(
                stringResource(R.string.login_title),
                style = MaterialTheme.typography.h1,
                color = MaterialTheme.colors.onPrimary,
                modifier = Modifier.paddingFromBaseline(top = 160.dp, bottom = 16.dp),
            )
            OutlinedTextField(
                "",
                onValueChange = {},
                placeholder = {
                    Text(
                        stringResource(R.string.email_placeholder),
                        style = MaterialTheme.typography.body1,
                        color = MaterialTheme.colors.onPrimary,
                    )
                },
                modifier = Modifier.fillMaxWidth(),
            )
            OutlinedTextField(
                "",
                onValueChange = {},
                placeholder = {
                    Text(
                        stringResource(R.string.password_placeholder),
                        style = MaterialTheme.typography.body1,
                        color = MaterialTheme.colors.onPrimary,
                    )
                },
                modifier = Modifier
                    .padding(top = 8.dp)
                    .fillMaxWidth(),
            )
            Text(
                with(AnnotatedString.Builder()) {
                    append(stringResource(R.string.login_description1))
                    append(" ")

                    pushStyle(
                        SpanStyle(
                            textDecoration = TextDecoration.Underline,
                        )
                    )
                    append(stringResource(R.string.terms_of_use))
                    pop()

                    append(" ")
                    append(stringResource(R.string.login_description2))
                    append(" ")

                    pushStyle(
                        SpanStyle(
                            textDecoration = TextDecoration.Underline,
                        )
                    )
                    append(stringResource(R.string.privacy_policy))
                    pop()

                    append(" ")
                    append(stringResource(R.string.login_description3))

                    toAnnotatedString()
                },
                style = MaterialTheme.typography.body2,
                color = MaterialTheme.colors.onPrimary,
                modifier = Modifier.paddingFromBaseline(top = 24.dp, bottom = 16.dp),
                textAlign = TextAlign.Center,
            )
            Button(
                onClick = onTapLogin,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = MaterialTheme.colors.secondary
                ),
                shape = MaterialTheme.shapes.medium,
            ) {
                Text(
                    stringResource(R.string.login),
                    style = MaterialTheme.typography.button,
                    color = MaterialTheme.colors.onSecondary,
                )
            }
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun WelcomePreview() {
    MyTheme {
        LogIn()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        LogIn()
    }
}
