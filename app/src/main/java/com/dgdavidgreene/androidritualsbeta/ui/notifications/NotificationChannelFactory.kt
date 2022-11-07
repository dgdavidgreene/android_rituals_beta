package com.dgdavidgreene.androidritualsbeta.ui.notifications

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import com.dgdavidgreene.androidritualsbeta.R

@RequiresApi(Build.VERSION_CODES.O)
class NotificationChannelFactory(private val applicationContext: Context) {

    private val notificationChannels: MutableList<NotificationChannel> = arrayListOf()

    fun createChannel(channelInfo: NotificationChannelInfo): NotificationChannel =
        NotificationChannel(channelInfo.id, channelInfo.name, channelInfo.priority).apply {
            description = channelInfo.description
        }

    fun init() {
        val generalChannel = createChannel(
            NotificationChannelInfo(
                applicationContext.getString(R.string.notifications_general_channel_id),
                applicationContext.getString(R.string.notifications_general_channel),
                applicationContext.getString(R.string.notifications_general_channel_description),
                NotificationManager.IMPORTANCE_DEFAULT
            )
        )

        val notificationManager: NotificationManager =
            applicationContext.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(generalChannel)
        notificationChannels.add(generalChannel)
    }

    data class NotificationChannelInfo(
        val id: String,
        val name: String,
        val description: String,
        val priority: Int
    )

}