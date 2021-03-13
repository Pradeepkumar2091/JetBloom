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
package com.example.androiddevchallenge.screen.home

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.theme.Elevations
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
fun ThemeItem(text: String, @DrawableRes image: Int) {
    Card(
        shape = MaterialTheme.shapes.small,
        elevation = Elevations.elevation01,
        modifier = Modifier
            .size(138.dp)
            .padding(2.dp),
    ) {
        Surface(color = MaterialTheme.colors.surface) {
            Column {
                Image(
                    painterResource(image),
                    contentScale = ContentScale.Crop,
                    contentDescription = null,
                    modifier = Modifier.height(96.dp),
                )
                Text(
                    text,
                    style = MaterialTheme.typography.h2,
                    color = MaterialTheme.colors.onPrimary,
                    modifier = Modifier
                        .height(40.dp)
                        .padding(start = 8.dp)
                        .paddingFromBaseline(top = 24.dp),
                )
            }
        }
    }
}

@Preview("Light Theme")
@Composable
fun ThemeItemPreview() {
    MyTheme {
        ThemeItem("Desert chic", R.drawable.desert_chic)
    }
}

@Preview("Dark Theme")
@Composable
fun ThemeItemDarkPreview() {
    MyTheme(darkTheme = true) {
        ThemeItem("Desert chic", R.drawable.desert_chic)
    }
}
