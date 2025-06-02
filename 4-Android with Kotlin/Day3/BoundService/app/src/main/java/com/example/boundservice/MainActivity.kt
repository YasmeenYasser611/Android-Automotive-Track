package com.example.boundservice

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import javax.security.auth.login.LoginException

class MainActivity : AppCompatActivity()
{
    lateinit var myService: BoundService
    var isBound :Boolean = false
    lateinit var tvTime : TextView
    lateinit var btnShow : Button
    lateinit var btnDownload : Button
    lateinit var tvurl : EditText


    private var myConnection:ServiceConnection = object : ServiceConnection {
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            val binder :BoundService.MyLocalBinder = service as BoundService.MyLocalBinder
            myService=binder.getService()
            isBound = true
        }

        override fun onServiceDisconnected(name: ComponentName?) {
            isBound = false
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val intent = Intent(this , BoundService::class.java)
        bindService(intent , myConnection , Context.BIND_AUTO_CREATE)

        tvTime = findViewById(R.id.textView)
        btnShow = findViewById(R.id.button)
        btnDownload = findViewById(R.id.download)
        tvurl = findViewById(R.id.url)
        btnShow.setOnClickListener{
            showTime()
        }
        btnDownload.setOnClickListener{
            var intent = Intent(this@MainActivity ,DownloadService::class.java )
            intent.putExtra("url" ,tvurl.text.toString() )
            startForegroundService(intent)

        }



    }
    fun showTime()
    {
        val currentTime :String=myService.getCurrentTime()
        Log.i("TAG", "showTime: $currentTime ")
        tvTime.text=currentTime

    }
}