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
package com.example.androiddevchallenge.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = Colors.green900,
    primaryVariant = Colors.green300,
    secondary = Colors.green300,
    background = Colors.gray,
    surface = Colors.white150,
    onPrimary = Colors.white,
    onSecondary = Colors.gray,
    onBackground = Colors.white,
    onSurface = Colors.white850,
)

private val LightColorPalette = lightColors(
    primary = Colors.pink100,
    primaryVariant = Colors.pink300,
    secondary = Colors.pink900,
    background = Colors.white,
    surface = Colors.white850,
    onPrimary = Colors.gray,
    onSecondary = Colors.white,
    onBackground = Colors.gray,
    onSurface = Colors.gray,
)

@Composable
fun MyTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable() () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = typography,
        shapes = shapes,
        content = content
    )
}
