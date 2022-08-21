package com.dgdavidgreene.androidritualsbeta.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.dgdavidgreene.androidritualsbeta.ui.screens.rituals.ritual.RitualScreen
import com.dgdavidgreene.androidritualsbeta.ui.screens.rituals.daily.RitualsDailyScreen
import com.dgdavidgreene.androidritualsbeta.ui.screens.rituals.initial.RitualsInitialScreen
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
        startDestination = Screen.RitualsDailyScreen.route
    ) {
        composable(route = Screen.RitualsInitialScreen.route) {
            RitualsInitialScreen(navController = navController)
        }

        composable(route = Screen.RitualsDailyScreen.route) {
            RitualsDailyScreen(navController = navController)
        }

        composable(route = Screen.RitualScreen.route  + "/{category}") {
            RitualScreen(navController = navController)
        }

        composable(route = Screen.SentimentListScreen.route) {
            SentimentListScreen(navController = navController)
        }

        composable(route = Screen.SentimentAddScreen.route) {
            SentimentAddScreen(navController = navController)
        }

        composable(route = Screen.SentimentViewScreen.route  + "/{sentimentId}") {
            SentimentViewScreen(navController = navController)
        }

        composable(route = Screen.SentimentEditScreen.route  + "/{sentimentId}") {
            SentimentEditScreen(navController = navController)
        }
    }
}