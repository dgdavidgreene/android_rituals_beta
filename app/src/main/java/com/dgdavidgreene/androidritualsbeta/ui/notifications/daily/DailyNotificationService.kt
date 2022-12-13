package com.dgdavidgreene.androidritualsbeta.ui.notifications.daily

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import com.dgdavidgreene.androidritualsbeta.MainActivity
import com.dgdavidgreene.androidritualsbeta.R
import android.content.Context

class DailyNotificationService(
    private val context: Context
) {

    private val dailyChannelID = context.getString(R.string.notifications_general_channel_id)
    private val alarmManager = context.getSystemService(Context.ALARM_SERVICE); // AlarmManager (AlarmManager)
    private val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

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
        val notification = NotificationCompat.Builder(context, dailyChannelID)
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

    /*fun showTimedNotification(counter: Int) {
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
        val notification = NotificationCompat.Builder(context, dailyChannelID)
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
        //alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,  System.currentTimeMillis(),1000 * 60 * 60 * 24, pendingIntent);
        notificationManager.notify(2, notification)
    }*/

    companion object {
        const val DAILY_CHANNEL_ID = "101"
        const val DAILY_CHANNEL_NAME = "Daily Channel"
        const val DAILY_CHANNEL_DESCRIPTION = "Daily Channel"
    }
} // AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
// alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,  System.currentTimeMillis(),
//            1000 * 60 * 60 * 24, pendingIntent);

