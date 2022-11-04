package com.dgdavidgreene.androidritualsbeta.ui.notifications.daily

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.provider.Settings.System.getString
import androidx.core.app.NotificationCompat
import com.dgdavidgreene.androidritualsbeta.MainActivity
import com.dgdavidgreene.androidritualsbeta.R
import androidx.compose.ui.res.stringResource as stringResource


class DailyNotificationService(
    private val context: Context
) {
    private val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

    fun createChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            // Create the NotificationChannel
            val name = DAILY_CHANNEL_NAME
            val descriptionText = DAILY_CHANNEL_DESCRIPTION
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val mChannel = NotificationChannel(DAILY_CHANNEL_ID, name, importance)
            mChannel.description = descriptionText
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            notificationManager.createNotificationChannel(mChannel)
        }
    }
    fun showNotification(counter: Int) {
        val activityIntent = Intent(context, MainActivity::class.java)
        val activityPendingIntent = PendingIntent.getActivity(
            context,
            3,
            activityIntent,
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) PendingIntent.FLAG_IMMUTABLE else 0
        )
        val incrementIntent = PendingIntent.getBroadcast(
            context,
            4,
            Intent(context, DailyNotificationReceiver::class.java),
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) PendingIntent.FLAG_IMMUTABLE else 0
        )
        val notification = NotificationCompat.Builder(context, DAILY_CHANNEL_ID)
            .setSmallIcon(com.google.android.material.R.drawable.abc_ic_star_black_16dp)
            .setContentTitle("Daily Increment counter")
            .setContentText("The count is $counter")
            .setContentIntent(activityPendingIntent)
            .addAction(
                androidx.appcompat.R.drawable.abc_ic_star_half_black_16dp,
                "Increment",
                incrementIntent
            )
            .build()

        notificationManager.notify(2, notification)
    }

    companion object {
        const val DAILY_CHANNEL_ID = "daily_channel"
        const val DAILY_CHANNEL_NAME = "Daily Channel"
        const val DAILY_CHANNEL_DESCRIPTION = "Daily Channel"
    }
}