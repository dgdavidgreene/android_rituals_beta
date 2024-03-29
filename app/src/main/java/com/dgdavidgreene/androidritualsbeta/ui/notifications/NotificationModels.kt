package com.dgdavidgreene.androidritualsbeta.ui.notifications

import android.app.PendingIntent
import androidx.annotation.DrawableRes

sealed class SkeletalNotification(
    val channelId: String,
    val title: String,
    val content: String,
    val priority: Int,
    val actions: List<NotificationAction> = listOf()
)

class BasicNotification(
    channelId: String,
    title: String,
    content: String,
    priority: Int,
    actions: List<NotificationAction> = listOf()
) : SkeletalNotification(channelId, title, content, priority, actions)

class TextExpandableNotification(
    channelId: String,
    title: String,
    content: String,
    priority: Int,
    val longText: String
) : SkeletalNotification(channelId, title, content, priority)

class PictureExpandableNotification(
    channelId: String,
    title: String,
    content: String,
    priority: Int,
    val bigContentTitle: String,
    @DrawableRes val picture: Int
) : SkeletalNotification(channelId, title, content, priority)

class InboxNotification(
    channelId: String,
    title: String,
    content: String,
    priority: Int,
    val lines: List<String>
) : SkeletalNotification(channelId, title, content, priority)

data class NotificationAction(
    val iconId: Int,
    val title: String,
    val actionIntent: PendingIntent
)

enum class NotificationType {
    BASIC, TEXT_EXPANDABLE, PICTURE_EXPANDABLE, BASIC_ACTION, INBOX
}
