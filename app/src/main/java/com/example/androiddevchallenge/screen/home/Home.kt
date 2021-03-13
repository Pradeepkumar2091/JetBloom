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
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.theme.Elevations
import com.example.androiddevchallenge.ui.theme.MyTheme

sealed class NavItem(val title: String, val icon: ImageVector) {
    object Home : NavItem("Home", Icons.Filled.Home)
    object Favorites : NavItem("Favorites", Icons.Filled.FavoriteBorder)
    object Profile : NavItem("Profile", Icons.Filled.AccountCircle)
    object Cart : NavItem("Cart", Icons.Filled.ShoppingCart)
}

val navItems = listOf(
    NavItem.Home,
    NavItem.Favorites,
    NavItem.Profile,
    NavItem.Cart,
)

sealed class GardenItem(val title: String, val description: String, @DrawableRes val image: Int) {
    object Aglaonema : GardenItem("Aglaonema", "This is a description", R.drawable.aglaonema)
    object DesertChic : GardenItem("Desert chic", "This is a description", R.drawable.desert_chic)
    object EasyCare : GardenItem("Easy care", "This is a description", R.drawable.easy_care)
    object FiddleLeaf : GardenItem("Fiddle leaf", "This is a description", R.drawable.fiddle_leaf)
    object JungleVibes :
        GardenItem("Jungle vibes", "This is a description", R.drawable.jungle_vibes)

    object Monstera : GardenItem("Monstera", "This is a description", R.drawable.monstera)
    object PeaceLily : GardenItem("Peace lily", "This is a description", R.drawable.peace_lily)
    object Photos : GardenItem("Photos", "This is a description", R.drawable.photos)
    object SnakePlant : GardenItem("Snake plant", "This is a description", R.drawable.snake_plant)
    object Statements : GardenItem("Statements", "This is a description", R.drawable.statements)
    object TinyTerrariums :
        GardenItem("Tiny terrariums", "This is a description", R.drawable.tiny_terrariums)
}

val gardenItems = listOf(
    GardenItem.Aglaonema,
    GardenItem.DesertChic,
    GardenItem.EasyCare,
    GardenItem.FiddleLeaf,
    GardenItem.JungleVibes,
    GardenItem.Monstera,
    GardenItem.PeaceLily,
    GardenItem.Photos,
    GardenItem.SnakePlant,
    GardenItem.Statements,
    GardenItem.TinyTerrariums,
)

@Composable
fun Home() {
    Scaffold(
        bottomBar = {
            BottomNavigation(
                elevation = Elevations.elevation16,
                modifier = Modifier.height(56.dp),
            ) {
                navItems.forEach { item ->
                    BottomNavigationItem(
                        icon = {
                            Icon(
                                item.icon,
                                contentDescription = null,
                                modifier = Modifier.size(24.dp),
                            )
                        },
                        label = {
                            Text(
                                item.title,
                                style = MaterialTheme.typography.caption,
                                color = MaterialTheme.colors.onPrimary,
                            )
                        },
                        selected = item == NavItem.Home,
                        onClick = {}
                    )
                }
            }
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(start = 16.dp, end = 16.dp, bottom = 56.dp),
        ) {
            OutlinedTextField(
                "",
                onValueChange = {},
                leadingIcon = {
                    Icon(
                        Icons.Filled.Search,
                        contentDescription = null,
                        modifier = Modifier.size(18.dp),
                    )
                },
                placeholder = {
                    Text(
                        stringResource(R.string.search_placeholder),
                        style = MaterialTheme.typography.body1,
                        color = MaterialTheme.colors.onPrimary,
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
            )

            Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
                Text(
                    stringResource(R.string.home_browse),
                    style = MaterialTheme.typography.h1,
                    color = MaterialTheme.colors.onPrimary,
                    modifier = Modifier.paddingFromBaseline(top = 32.dp),
                )

                LazyRow(modifier = Modifier.padding(top = 16.dp)) {
                    items(gardenItems) { item ->
                        ThemeItem(item.title, item.image)
                        Spacer(modifier = Modifier.size(8.dp))
                    }
                }

                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp),
                ) {
                    Text(
                        stringResource(R.string.home_design),
                        style = MaterialTheme.typography.h1,
                        color = MaterialTheme.colors.onPrimary,
                        modifier = Modifier.paddingFromBaseline(top = 40.dp),
                    )
                    Icon(
                        Icons.Filled.FilterList,
                        contentDescription = null,
                        modifier = Modifier
                            .padding(top = 16.dp)
                            .size(24.dp),
                    )
                }
                for (item in gardenItems) {
                    DesignItem(item.title, item.description, item.image)
                    Spacer(modifier = Modifier.size(8.dp))
                }
            }
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun HomePreview() {
    MyTheme {
        Home()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun HomeDarkPreview() {
    MyTheme(darkTheme = true) {
        Home()
    }
}
