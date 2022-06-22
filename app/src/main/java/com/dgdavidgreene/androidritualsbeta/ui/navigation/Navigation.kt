package com.dgdavidgreene.androidritualsbeta.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.dgdavidgreene.androidritualsbeta.ui.screens.rituals.sentiments.list.SentimentListScreen
import com.dgdavidgreene.androidritualsbeta.ui.screens.splash.SplashScreen

@Composable
fun Navigation(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.SplashScreen.route
    ) {

        composable(route = Screen.SplashScreen.route) {
            SplashScreen(navController = navController)
        }
        composable(route = Screen.SentimentListScreen.route) {
            SentimentListScreen(navController = navController)
        }
    }
}