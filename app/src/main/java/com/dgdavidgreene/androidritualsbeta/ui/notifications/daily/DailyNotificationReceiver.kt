package com.dgdavidgreene.androidritualsbeta.ui.notifications.daily

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class DailyNotificationReceiver: BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        val service = DailyNotificationService(context)
        val extra = intent.getIntExtra("my_extra", 0)

        service.showNotification(++DCounter.value + extra)
    }
}