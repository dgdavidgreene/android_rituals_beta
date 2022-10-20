package com.dgdavidgreene.androidritualsbeta.ui.notifications

import android.content.Context
import com.dgdavidgreene.androidritualsbeta.ui.notifications.counter.CounterNotificationService

class NotificationService(private val applicationContext: Context) {
    fun launchNotificationChannels() {
        CounterNotificationService(applicationContext)
    }
}