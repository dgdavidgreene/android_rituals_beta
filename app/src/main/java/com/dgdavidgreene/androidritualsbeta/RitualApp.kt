package com.dgdavidgreene.androidritualsbeta

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import com.dgdavidgreene.androidritualsbeta.ui.notifications.counter.CounterNotificationService
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class RitualApp: Application() {

    override fun onCreate() {
        super.onCreate()
        createCounterNotificationChannel()
    }

    private fun createCounterNotificationChannel() {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                CounterNotificationService.COUNTER_CHANNEL_ID,
                "Counter",
                NotificationManager.IMPORTANCE_DEFAULT
            )
            channel.description = "Used for the increment counter notifications"

            val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }
}