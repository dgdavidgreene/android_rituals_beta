package com.dgdavidgreene.androidritualsbeta.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.dgdavidgreene.androidritualsbeta.ui.screens.rituals.sentiments.list.SentimentListScreen
import com.dgdavidgreene.androidritualsbeta.ui.screens.rituals.sentiments.add.SentimentAddScreen
import com.dgdavidgreene.androidritualsbeta.ui.screens.rituals.sentiments.edit.SentimentEditScreen
import com.dgdavidgreene.androidritualsbeta.ui.screens.rituals.sentiments.view.SentimentViewScreen

@Composable
fun Navigation(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.SentimentListScreen.route
    ) {
        composable(route = Screen.SentimentListScreen.route) {
            SentimentListScreen(navController = navController)
        }

        composable(route = Screen.SentimentAddScreen.route) {
            SentimentAddScreen(navController = navController)
        }

        composable(route = Screen.SentimentViewScreen.route) {
            SentimentViewScreen(navController = navController)
        }

        composable(route = Screen.SentimentEditScreen.route) {
            SentimentEditScreen(navController = navController)
        }
    }
}