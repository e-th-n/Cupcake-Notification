package com.example.cupcake

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import androidx.core.app.NotificationCompat

// Notification ID.
private val NOTIFICATION_ID = 0
private val REQUEST_CODE = 0
private val FLAGS = 0

/**
 * Builds and delivers the notification.
 *
 * @param context, activity context.
 */
fun NotificationManager.sendNotification(messageBody: String, applicationContext: Context) {
    // Create the content intent for the notification, which launches

    //Create the intent
    val contentIntent = Intent(applicationContext, MainActivity::class.java)

    //Create the pendingIntent
    val contentPendingIntent = PendingIntent.getActivity(
            applicationContext,
            NOTIFICATION_ID,
            contentIntent,
            PendingIntent.FLAG_UPDATE_CURRENT
    )

    //Give the notification style
    val cupcakeImage = BitmapFactory.decodeResource(
            applicationContext.resources,
            R.drawable.cupcake
    )
    val bigPicStyle = NotificationCompat.BigPictureStyle()
            .bigPicture(cupcakeImage)
            .bigLargeIcon(null)

    // Build the notification
    val builder = NotificationCompat.Builder(
            applicationContext,
            applicationContext.getString(R.string.cupcake_channel_id)
    )

            //Set the title, text and icon for the notification
            .setSmallIcon(R.drawable.cupcake)
            .setContentTitle(applicationContext
                    .getString(R.string.notification_title))
            .setContentText(messageBody)

            //sets the content intent
            .setContentIntent(contentPendingIntent)
            .setAutoCancel(true)

            //Gives style to the builder
            .setStyle(bigPicStyle)
            .setLargeIcon(cupcakeImage)

            //Set the priority for the notification
            .setPriority(NotificationCompat.PRIORITY_HIGH)

    //Call notify
    notify(NOTIFICATION_ID, builder.build())
}

/**Cancels all notifications.*/
fun NotificationManager.cancelNotifications() {
    cancelAll()
}