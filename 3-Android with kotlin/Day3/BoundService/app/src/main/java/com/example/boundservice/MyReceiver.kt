package com.example.boundservice

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity

class MyReceiver : BroadcastReceiver()
{

    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent?.action == "DOWNLOAD_COMPLETE")
        {
            val imagepath = intent.getStringExtra("internal_path")
            val displayIntent = Intent(context, ImageActivity::class.java).apply {
                putExtra("image_path", imagepath)
                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            }
            context?.startActivity(displayIntent)
        }
    }
}