package com.apka.spendly.service

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import com.apka.spendly.MainActivity
import com.apka.spendly.R
import com.apka.spendly.androidUuidGenerator.AndroidUuidGenerator
import com.apka.spendly.data.model.fcmToken
import com.apka.spendly.data.repo.FCMTokenRepo
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject

class PushNotificationService : FirebaseMessagingService() {
    private val fcmTokenRepo: FCMTokenRepo by inject()
    private val androidUuidGenerator: AndroidUuidGenerator by inject()

    override fun onNewToken(token: String) {
        super.onNewToken(token)

        val uuid = androidUuidGenerator.getOrCreateGuid()

        val fcmTokenData = fcmToken(
            uuid = uuid,
            fcmToken = token
        )

        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = fcmTokenRepo.saveFcmToken(fcmTokenData)
                println("FCM Token saved successfully: $response")
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    override fun onMessageReceived(message: RemoteMessage) {
        val title = message.data["title"] ?: message.notification?.title
        val body = message.data["body"] ?: message.notification?.body

        if (title != null && body != null) {
            showNotification(title, body)
        }
    }

    private fun showNotification(title: String?, body: String?) {
        val channelId = "default_channel"

        val notificationManager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                channelId,
                "Default Channel",
                NotificationManager.IMPORTANCE_DEFAULT
            )
            notificationManager.createNotificationChannel(channel)
        }

        val intent = Intent(this, MainActivity::class.java)

        val pendingIntent = PendingIntent.getActivity(
            this,
            0,
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )

        val notification = NotificationCompat.Builder(this, channelId)
            .setContentTitle(title)
            .setContentText(body)
            .setSmallIcon(R.drawable.app_icon)
            .setContentIntent(pendingIntent)
            .build()

        notificationManager.notify(System.currentTimeMillis().toInt(), notification)
    }
}