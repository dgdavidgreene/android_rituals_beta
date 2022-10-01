package com.dgdavidgreene.androidritualsbeta

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.dgdavidgreene.androidritualsbeta.ui.navigation.Navigation
import com.dgdavidgreene.androidritualsbeta.ui.theme.AndroidRitualsBetaTheme
import dagger.hilt.android.AndroidEntryPoint
import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build

import android.os.Handler
import android.view.View
import android.view.ViewTreeObserver
// import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.dgdavidgreene.androidritualsbeta.ui.notifications.counter.CounterNotificationService


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val service = CounterNotificationService(applicationContext)
        installSplashScreen()
        //setContentView(R.layout.activity_main)
    setContent {
        AndroidRitualsBetaTheme {
            // A surface container using the 'background' color from the theme
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colors.background
            ) {
                val navController = rememberNavController()
                Navigation(navController)
            }
        }
    }
        /*var isReady = true*/
        var isReady = false

        Handler(mainLooper).postDelayed({
            isReady = true
        }, 0)

        // Set up an OnPreDrawListener to the root view.
        val content: View = findViewById(android.R.id.content)
        content.viewTreeObserver.addOnPreDrawListener(
            object : ViewTreeObserver.OnPreDrawListener {
                override fun onPreDraw(): Boolean {
                    // Check if the initial data is ready.
                    return if (isReady) {
                        // The content is ready; start drawing.
                        content.viewTreeObserver.removeOnPreDrawListener(this)
                        true
                    } else {
                        // The content is not ready; suspend.
                        false
                    }
                }
            }
        )
    }
}
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AndroidRitualsBetaTheme {
        //Greeting("Android")
    }
}