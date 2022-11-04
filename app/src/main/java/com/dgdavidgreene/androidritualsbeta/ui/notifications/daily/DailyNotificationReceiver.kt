package com.dgdavidgreene.androidritualsbeta.ui.notifications.daily

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class DailyNotificationReceiver: BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent?) {
        val service = DailyNotificationService(context)
        service.showNotification(++Counter.value)
    }
}