package com.dgdavidgreene.androidritualsbeta.ui.notifications

import android.content.Context
import com.dgdavidgreene.androidritualsbeta.ui.notifications.counter.CounterNotificationService
import com.dgdavidgreene.androidritualsbeta.ui.notifications.daily.DailyNotificationService

class NotificationService(private val applicationContext: Context) {
    fun launchNotificationChannels() {
        DailyNotificationService(applicationContext)
        CounterNotificationService(applicationContext)
    }
}