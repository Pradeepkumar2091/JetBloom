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
package com.example.androiddevchallenge.ui.navigation

import android.view.Window
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.toArgb
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.screen.home.Home
import com.example.androiddevchallenge.screen.login.LogIn
import com.example.androiddevchallenge.screen.welcome.Welcome

object MainDestinations {
    const val WELCOME_ROUTE = "welcome"
    const val LOGIN_ROUTE = "login"
    const val HOME_ROUTE = "home"
}

@Composable
fun NavGraph(window: Window, startDestination: String = MainDestinations.WELCOME_ROUTE) {
    val navController = rememberNavController()
    val actions = remember(navController) { MainActions(navController) }
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(MainDestinations.WELCOME_ROUTE) {
            window.statusBarColor = MaterialTheme.colors.primary.toArgb()
            Welcome(
                onTapLogin = actions.login,
            )
        }
        composable(MainDestinations.LOGIN_ROUTE) {
            window.statusBarColor = MaterialTheme.colors.background.toArgb()
            LogIn(
                onTapLogin = actions.home,
            )
        }
        composable(MainDestinations.HOME_ROUTE) {
            window.statusBarColor = MaterialTheme.colors.background.toArgb()
            Home()
        }
    }
}

class MainActions(navController: NavHostController) {
    val login: () -> Unit = {
        navController.navigate(MainDestinations.LOGIN_ROUTE)
    }
    val home: () -> Unit = {
        navController.navigate(MainDestinations.HOME_ROUTE)
    }
    val upPress: () -> Unit = {
        navController.navigateUp()
    }
}
