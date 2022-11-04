package com.dgdavidgreene.androidritualsbeta

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import com.dgdavidgreene.androidritualsbeta.ui.notifications.counter.CounterNotificationService
import com.dgdavidgreene.androidritualsbeta.ui.notifications.daily.DailyNotificationService
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class RitualApp: Application() {

    override fun onCreate() {
        super.onCreate()
        createCounterNotificationChannel()
        createDailyNotificationChannel()
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

    private fun createDailyNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            // Create the NotificationChannel
            val name = DailyNotificationService.DAILY_CHANNEL_NAME
            val descriptionText = DailyNotificationService.DAILY_CHANNEL_DESCRIPTION
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val mChannel =
                NotificationChannel(DailyNotificationService.DAILY_CHANNEL_ID, name, importance)
            mChannel.description = descriptionText
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            val notificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(mChannel)
        }
    }
    companion object {
        const val DAILY_CHANNEL_ID = "daily_channel"
        const val DAILY_CHANNEL_NAME = "Daily Channel"
        const val DAILY_CHANNEL_DESCRIPTION = "Daily Channel"
    }
}