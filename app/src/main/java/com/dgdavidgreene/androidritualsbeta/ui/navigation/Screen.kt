package com.dgdavidgreene.androidritualsbeta.ui.navigation

sealed class Screen(val route:String) {
    object SplashScreen : Screen("splash_screen")
}