package org.d3if2092.assessment1.network

import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.work.Worker
import androidx.work.WorkerParameters
import org.d3if2092.assessment1.DosenActivity
import org.d3if2092.assessment1.R

class UpdateWorker(context: Context, workerParams: WorkerParameters) : Worker(context, workerParams) {

    private val notificationId = 44

    override fun doWork(): Result {
        val builder = NotificationCompat.Builder(applicationContext,
            DosenActivity.CHANNEL_ID)
            .setSmallIcon(R.mipmap.ic_launcher_round)
            .setContentTitle(applicationContext.getString(R.string.notif_title))
            .setContentText(applicationContext.getString(R.string.notif_text))
            .setPriority(NotificationCompat.PRIORITY_HIGH)
        val manager = NotificationManagerCompat.from(applicationContext)
        manager.notify(notificationId, builder.build())

        return Result.success()
    }
}

