package com.dgdavidgreene.androidritualsbeta.ui.navigation

sealed class Screen(val route:String) {
    object RitualsInitialScreen : Screen("rituals_initial_screen")
    object RitualsDailyScreen : Screen("rituals_daily_screen")
    object SentimentListScreen : Screen("sentiment_list_screen")
    object SentimentAddScreen : Screen("sentiment_add_screen")
    object SentimentEditScreen : Screen("sentiment_edit_screen")
    object SentimentViewScreen : Screen("sentiment_view_screen")
}