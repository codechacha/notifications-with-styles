
package com.codechacha.sample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.app.NotificationManager
import android.app.NotificationChannel
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Build
import android.view.View
import androidx.core.app.NotificationCompat
import androidx.media.app.NotificationCompat.MediaStyle
import androidx.core.app.NotificationManagerCompat
import androidx.core.app.Person
import androidx.core.app.RemoteInput
import androidx.core.graphics.drawable.IconCompat


class MainActivity : AppCompatActivity() {
    companion object {
        const val TAG = "MainActivity"
        const val NOTIFICATION_ID = 1001
        const val NOTIFICATION_ID_2 = 1002
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun basic(v: View) {
        clearExistingNotifications(NOTIFICATION_ID)
        clearExistingNotifications(NOTIFICATION_ID_2)
        createNotificationChannel(this, NotificationManagerCompat.IMPORTANCE_DEFAULT, false,
            getString(R.string.app_name), "App notification channel")

        val channelId = "$packageName-${getString(R.string.app_name)}"
        val title = "Android Developer"
        val content = "Notifications in Android P"

        val intent = Intent(baseContext, NewActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        val pendingIntent = PendingIntent.getActivity(baseContext, 0,
            intent, PendingIntent.FLAG_UPDATE_CURRENT)

        val builder = NotificationCompat.Builder(this, channelId)
        builder.setSmallIcon(R.drawable.ic_codechacha)
        builder.setContentTitle(title)
        builder.setContentText(content)
        builder.priority = NotificationCompat.PRIORITY_DEFAULT
        builder.setAutoCancel(true)
        builder.setContentIntent(pendingIntent)

        val notificationManager = NotificationManagerCompat.from(this)
        notificationManager.notify(NOTIFICATION_ID, builder.build())
    }

    fun bigTextStyle(v: View) {
        clearExistingNotifications(NOTIFICATION_ID)
        clearExistingNotifications(NOTIFICATION_ID_2)
        createNotificationChannel(this, NotificationManagerCompat.IMPORTANCE_DEFAULT, false,
                getString(R.string.app_name), "App notification channel")

        val channelId = "$packageName-${getString(R.string.app_name)}"
        val title = "Android Developer"
        val content = "Notifications in Android P"

        val intent = Intent(baseContext, NewActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        val pendingIntent = PendingIntent.getActivity(baseContext, 0,
                intent, PendingIntent.FLAG_UPDATE_CURRENT)

        val bigText = "Android 9 introduces several enhancements to notifications," +
                " all of which are available to developers targeting API level 28 and above."
        val style = NotificationCompat.BigTextStyle()
        style.bigText(bigText)

        val builder = NotificationCompat.Builder(this, channelId)
        builder.setSmallIcon(R.drawable.ic_codechacha)
        builder.setContentTitle(title)
        builder.setContentText(content)
        builder.setStyle(style)
        builder.priority = NotificationCompat.PRIORITY_DEFAULT
        builder.setAutoCancel(true)
        builder.setContentIntent(pendingIntent)

        val notificationManager = NotificationManagerCompat.from(this)
        notificationManager.notify(NOTIFICATION_ID, builder.build())
    }

    fun bigPictureStyle(v: View) {
        clearExistingNotifications(NOTIFICATION_ID)
        clearExistingNotifications(NOTIFICATION_ID_2)
        createNotificationChannel(this, NotificationManagerCompat.IMPORTANCE_DEFAULT, false,
            getString(R.string.app_name), "App notification channel")

        val channelId = "$packageName-${getString(R.string.app_name)}"
        val title = "Castle"
        val content = "Welcome to my catle"

        val intent = Intent(baseContext, NewActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        val pendingIntent = PendingIntent.getActivity(baseContext, 0,
                intent, PendingIntent.FLAG_UPDATE_CURRENT)

        val style = NotificationCompat.BigPictureStyle()
        style.bigPicture(BitmapFactory.decodeResource(resources, R.drawable.castle))

        val builder = NotificationCompat.Builder(this, channelId)
        builder.setSmallIcon(R.drawable.ic_codechacha)
        builder.setContentTitle(title)
        builder.setContentText(content)
        builder.setStyle(style)
        builder.priority = NotificationCompat.PRIORITY_DEFAULT
        builder.setAutoCancel(true)
        builder.setContentIntent(pendingIntent)

        val notificationManager = NotificationManagerCompat.from(this)
        notificationManager.notify(NOTIFICATION_ID, builder.build())
    }

    fun inboxStyle(v: View) {
        clearExistingNotifications(NOTIFICATION_ID)
        clearExistingNotifications(NOTIFICATION_ID_2)
        createNotificationChannel(this, NotificationManagerCompat.IMPORTANCE_DEFAULT, false,
            getString(R.string.app_name), "App notification channel")

        val channelId = "$packageName-${getString(R.string.app_name)}"
        val title = "3 Mails"
        val content = "+5 Mails"

        val intent = Intent(baseContext, NewActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        val pendingIntent = PendingIntent.getActivity(baseContext, 0,
                intent, PendingIntent.FLAG_UPDATE_CURRENT)

        val style = NotificationCompat.InboxStyle()
        style.addLine("Mail1 ...")
        style.addLine("Mail2 ...")
        style.addLine("Mail3 ...")

        val builder = NotificationCompat.Builder(this, channelId)
        builder.setSmallIcon(R.drawable.ic_codechacha)
        builder.setContentTitle(title)
        builder.setContentText(content)
        builder.setStyle(style)
        builder.priority = NotificationCompat.PRIORITY_DEFAULT
        builder.setAutoCancel(true)
        builder.setContentIntent(pendingIntent)

        val notificationManager = NotificationManagerCompat.from(this)
        notificationManager.notify(NOTIFICATION_ID, builder.build())
    }

    fun messagingStyle(v: View) {
        clearExistingNotifications(NOTIFICATION_ID)
        clearExistingNotifications(NOTIFICATION_ID_2)
        createNotificationChannel(this, NotificationManagerCompat.IMPORTANCE_DEFAULT, false,
            getString(R.string.app_name), "App notification channel")

        val channelId = "$packageName-${getString(R.string.app_name)}"
        val title = "Messaging style title"
        val content = "Messaging style content"

        val intent = Intent(baseContext, NewActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        val pendingIntent = PendingIntent.getActivity(baseContext, 0,
                intent, PendingIntent.FLAG_UPDATE_CURRENT)

        val userIcon1 = IconCompat.createWithResource(this, R.drawable.codechacha)
        val userIcon2 = IconCompat.createWithResource(this, R.drawable.android)
        val userIcon3 = IconCompat.createWithResource(this, R.drawable.android)
        val userName1 = "Chacha"
        val userName2 = "Android"
        val userName3 = "JS"
        val timestamp = System.currentTimeMillis()
        val user1 = Person.Builder().setIcon(userIcon1).setName(userName1).build()
        val user2 = Person.Builder().setIcon(userIcon2).setName(userName2).build()
        val user3 = Person.Builder().setIcon(userIcon3).setName(userName3).build()
        val style = NotificationCompat.MessagingStyle(user3)
        style.addMessage("You can get great deals there", timestamp, user1)
        style.addMessage("I know what to get", timestamp, user2)

        val builder = NotificationCompat.Builder(this, channelId)
        builder.setSmallIcon(R.drawable.ic_codechacha)
        builder.setContentTitle(title)
        builder.setContentText(content)
        builder.setStyle(style)
        builder.priority = NotificationCompat.PRIORITY_DEFAULT
        builder.setAutoCancel(true)
        builder.setContentIntent(pendingIntent)

        val notificationManager = NotificationManagerCompat.from(this)
        notificationManager.notify(NOTIFICATION_ID, builder.build())
    }

    fun mediaStyle(v: View) {
        clearExistingNotifications(NOTIFICATION_ID)
        clearExistingNotifications(NOTIFICATION_ID_2)
        createNotificationChannel(this, NotificationManagerCompat.IMPORTANCE_DEFAULT, false,
            getString(R.string.app_name), "App notification channel")

        val channelId = "$packageName-${getString(R.string.app_name)}"
        val title = "Don't Say a Word"
        val content = "Ellie Goulding"

        val intent = Intent(baseContext, NewActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        val pendingIntent = PendingIntent.getActivity(baseContext, 0,
                intent, PendingIntent.FLAG_UPDATE_CURRENT)

        val builder = NotificationCompat.Builder(this, channelId)
        builder.setSmallIcon(R.drawable.ic_codechacha)
        builder.setContentTitle(title)
        builder.setContentText(content)
        builder.setLargeIcon(BitmapFactory.decodeResource(resources, R.drawable.castle))
        builder.addAction(NotificationCompat.Action(
            R.drawable.ic_thumb_down,"skip prev", pendingIntent))
        builder.addAction(NotificationCompat.Action(
            R.drawable.ic_skip_prev,"skip prev", pendingIntent))
        builder.addAction(NotificationCompat.Action(
            R.drawable.ic_pause,"pause", pendingIntent))
        builder.addAction(NotificationCompat.Action(
            R.drawable.ic_skip_next,"skip next", pendingIntent))
        builder.addAction(NotificationCompat.Action(
            R.drawable.ic_thumb_up,"skip prev", pendingIntent))
        builder.setStyle(MediaStyle().setShowActionsInCompactView(1, 2, 3))
        builder.priority = NotificationCompat.PRIORITY_DEFAULT
        builder.setAutoCancel(true)
        builder.setContentIntent(pendingIntent)


        val notificationManager = NotificationManagerCompat.from(this)
        notificationManager.notify(NOTIFICATION_ID, builder.build())
    }

    fun inlineReplay(v: View) {
        clearExistingNotifications(NOTIFICATION_ID)
        clearExistingNotifications(NOTIFICATION_ID_2)
        createNotificationChannel(this, NotificationManagerCompat.IMPORTANCE_DEFAULT, false,
            getString(R.string.app_name), "App notification channel")

        val channelId = "$packageName-${getString(R.string.app_name)}"
        val title = "3 Messages"
        val content = "+5 Messages"

        val intent = Intent(baseContext, NewActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        val pendingIntent = PendingIntent.getActivity(baseContext, 0,
            intent, PendingIntent.FLAG_UPDATE_CURRENT)

        val replyLabel = "Enter your reply here"
        val remoteInput = RemoteInput.Builder("key_reply")
            .setLabel(replyLabel)
            .build()
        val replyAction = NotificationCompat.Action.Builder(
            android.R.drawable.sym_action_chat, "REPLY", pendingIntent)
            .addRemoteInput(remoteInput)
            .setAllowGeneratedReplies(true)
            .build()

        val userIcon1 = IconCompat.createWithResource(this, R.drawable.codechacha)
        val userIcon2 = IconCompat.createWithResource(this, R.drawable.android)
        val userIcon3 = IconCompat.createWithResource(this, R.drawable.person)
        val userName1 = "Chacha"
        val userName2 = "Android"
        val userName3 = "JS"
        val timestamp = System.currentTimeMillis()
        val user1 = Person.Builder().setIcon(userIcon1).setName(userName1).build()
        val user2 = Person.Builder().setIcon(userIcon2).setName(userName2).build()
        val user3 = Person.Builder().setIcon(userIcon3).setName(userName3).build()
        val style = NotificationCompat.MessagingStyle(user3)
        style.addMessage("You can get great deals there", timestamp, user1)
        style.addMessage("I know what to get", timestamp, user2)

        val builder = NotificationCompat.Builder(this, channelId)
        builder.setSmallIcon(R.drawable.ic_codechacha)
        builder.setContentTitle(title)
        builder.setContentText(content)
        builder.setStyle(style)
        builder.priority = NotificationCompat.PRIORITY_DEFAULT
        builder.setAutoCancel(true)
        builder.setContentIntent(pendingIntent)
        builder.addAction(replyAction)
        builder.addAction(android.R.drawable.ic_menu_close_clear_cancel, "DISMISS", pendingIntent);

        val notificationManager = NotificationManagerCompat.from(this)
        notificationManager.notify(NOTIFICATION_ID, builder.build())
    }

    fun headUp(v: View) {
        clearExistingNotifications(NOTIFICATION_ID)
        clearExistingNotifications(NOTIFICATION_ID_2)
        createNotificationChannel(this, NotificationManagerCompat.IMPORTANCE_HIGH, false,
            getString(R.string.app_name), "App notification channel")

        val channelId = "$packageName-${getString(R.string.app_name)}"
        val title = "Android Developer"
        val content = "Notifications in Android P"

        val intent = Intent(baseContext, NewActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        val fullScreenPendingIntent = PendingIntent.getActivity(baseContext, 0,
                intent, PendingIntent.FLAG_UPDATE_CURRENT)

        val builder = NotificationCompat.Builder(this, channelId)
        builder.setSmallIcon(R.drawable.ic_codechacha)
        builder.setContentTitle(title)
        builder.setContentText(content)
        builder.priority = NotificationCompat.PRIORITY_HIGH
        builder.setAutoCancel(true)
        builder.setFullScreenIntent(fullScreenPendingIntent, true)

        val notificationManager = NotificationManagerCompat.from(this)
        notificationManager.notify(NOTIFICATION_ID_2, builder.build())
    }

    private fun createNotificationChannel(context: Context, importance: Int, showBadge: Boolean,
                                          name: String, description: String) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channelId = "${context.packageName}-$name"
            val channel = NotificationChannel(channelId, name, importance)
            channel.description = description
            channel.setShowBadge(showBadge)

            val notificationManager = context.getSystemService(NotificationManager::class.java)
            notificationManager.createNotificationChannel(channel)
        }
    }

    private fun clearExistingNotifications(notificationId: Int) {
        val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        manager.cancel(notificationId)
    }
}
