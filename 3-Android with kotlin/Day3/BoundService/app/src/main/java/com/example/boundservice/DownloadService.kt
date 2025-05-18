package com.example.boundservice

import android.annotation.SuppressLint
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Build
import android.os.IBinder
import android.util.Log
import androidx.core.app.NotificationCompat
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.net.URL
import javax.net.ssl.HttpsURLConnection


class DownloadService : Service()
{
    private val CHANNEL_ID = "DownloadServiceChannel"
    lateinit var reciever: MyReceiver

    override fun onBind(intent: Intent): IBinder? {
        return null
    }
    @SuppressLint("UnspecifiedRegisterReceiverFlag")
    override fun onCreate()
    {
        super.onCreate()
        createNotificationChannel()
        val notification = createNotification("Downloading image...")
        startForeground(1, notification)

        val intentFilter:IntentFilter = IntentFilter("DOWNLOAD_COMPLETE")
        reciever = MyReceiver()
        registerReceiver(reciever , intentFilter )
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.i("TAG", "onStartCommand: ")
        val url = intent?.getStringExtra("url") ?: return START_NOT_STICKY

        /*val notification = createNotification("Downloading image...")
        startForeground(1, notification)*/

        Thread{
            val bitmap = Download(url)
            val internalFile = saveImageToInternalStorage(bitmap!!)
            sendDownloadCompleteBroadcast( internalFile?.path)
            stopSelf()
        }.start()
        return START_NOT_STICKY
    }
    private fun createNotification(contentText: String): Notification {
        return NotificationCompat.Builder(this, CHANNEL_ID)
            .setContentTitle("Image Download")
            .setContentText(contentText)
            .setSmallIcon(R.drawable.ic_launcher_background)
            .setPriority(NotificationCompat.PRIORITY_LOW)
            .build()
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val serviceChannel = NotificationChannel(CHANNEL_ID, "Download Service Channel", NotificationManager.IMPORTANCE_LOW)
            val manager = getSystemService(NotificationManager::class.java)
            manager.createNotificationChannel(serviceChannel)
        }
    }

    @Throws(IOException::class)
    private fun Download(url: String): Bitmap? {
        val imgurl = URL(url)
        val connection = imgurl.openConnection() as HttpsURLConnection
        connection.requestMethod = "GET"
        connection.connect()
        val responseCode = connection.responseCode
        if (responseCode == HttpsURLConnection.HTTP_OK) {
            val `is` = connection.inputStream
            return BitmapFactory.decodeStream(`is`)
        } else {
            return null
        }
    }
    private fun sendDownloadCompleteBroadcast( internalPath: String?) {
        val intent = Intent("DOWNLOAD_COMPLETE").apply {
            putExtra("internal_path", internalPath)


        }
        Log.i("TAG", "sendDownloadCompleteBroadcast: $internalPath")
        sendBroadcast(intent)
    }
    private fun saveImageToInternalStorage(bitmap: Bitmap): File?
    {
        return try {

            val filename = "image_${System.currentTimeMillis()}.jpg"
            val file = File(filesDir, filename)


            FileOutputStream(file).use { outputStream ->
                bitmap.compress(Bitmap.CompressFormat.JPEG, 90, outputStream)
            }
            file
        } catch (e: IOException) {
            Log.e("DownloadService", "Failed to save image", e)
            null
        }
    }

    override fun onDestroy()
    {
        super.onDestroy()
        unregisterReceiver(reciever)

    }
}