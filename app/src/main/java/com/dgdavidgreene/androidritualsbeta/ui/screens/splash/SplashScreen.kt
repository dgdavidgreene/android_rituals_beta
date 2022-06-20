package com.dgdavidgreene.androidritualsbeta.ui.screens.splash


import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.dgdavidgreene.androidritualsbeta.Greeting
import com.dgdavidgreene.androidritualsbeta.R
import com.dgdavidgreene.androidritualsbeta.ui.components.ImageButton
import com.dgdavidgreene.androidritualsbeta.ui.navigation.Screen
import com.dgdavidgreene.androidritualsbeta.ui.theme.LocalSpacing

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

@Composable
fun SplashScreen(
    navController: NavController,
    dispatcher : CoroutineDispatcher = Dispatchers.Main
) {
    val spacing = LocalSpacing.current
    val scale = remember {
        Animatable(0f)
    }

    val overshootInterpolator = remember {
        OvershootInterpolator(2f)
    }

    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Greeting("Rituals Beta")
    }
    LaunchedEffect(key1 = true) {
        withContext(dispatcher) {
            scale.animateTo(
                targetValue = 0.5F,
                animationSpec = tween(
                    durationMillis = 1000,
                    easing = {
                        overshootInterpolator.getInterpolation(it)
                    }
                ),
            )
            /*delay(1000L)
            navController.popBackStack()
            navController.navigate(Screen.NotesScreen.route)*/
        }
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_praying_hands_solid_svgrepo_com),
            contentDescription = stringResource(id = R.string.logo),
            modifier = Modifier.size(spacing.dp64).scale(scale.value)
        )

    }
}