package com.dgdavidgreene.androidritualsbeta.ui.notifications

import android.app.Notification
import android.content.Context
import android.graphics.BitmapFactory
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.dgdavidgreene.androidritualsbeta.R


class NotificationFactory(private val applicationContext: Context) {

    private fun createNotification(model: SkeletalNotification): Notification {
        return NotificationCompat.Builder(applicationContext, model.channelId)
            .setSmallIcon(R.drawable.ic_praying_hands_solid_svgrepo_com)
            .setContentTitle(model.title)
            .setContentText(model.content)
            .setPriority(model.priority)
            .setAutoCancel(true)
            .apply {
                when (model) {
                    is TextExpandableNotification -> {
                        setStyle(NotificationCompat.BigTextStyle().bigText(model.longText))
                    }
                    is PictureExpandableNotification -> {
                        val pictureBitmap =
                            BitmapFactory.decodeResource(applicationContext.resources, model.picture)
                        setLargeIcon(pictureBitmap)
                        setStyle(
                            NotificationCompat.BigPictureStyle()
                                .bigPicture(pictureBitmap)
                                .bigLargeIcon(null)
                                .setBigContentTitle(model.bigContentTitle)
                        )
                    }
                    is InboxNotification -> {
                        val inboxStyle = NotificationCompat.InboxStyle()

                        model.lines.forEach {
                            inboxStyle.addLine(it)
                        }

                        setStyle(inboxStyle)
                    }
                }

                model.actions.forEach { (iconId, title, actionIntent) ->
                    addAction(iconId, title, actionIntent)
                }
            }
            .build()
    }

    fun showNotification(id: Int, notification: SkeletalNotification) {
        NotificationManagerCompat
            .from(applicationContext)
            .notify(id, createNotification(notification))
    }

}