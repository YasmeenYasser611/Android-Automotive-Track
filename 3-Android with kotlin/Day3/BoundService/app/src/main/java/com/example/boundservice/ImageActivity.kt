package com.example.boundservice

import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.io.File

class ImageActivity : AppCompatActivity()
{
    private lateinit var imageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image)
        Log.i("TAG", "onCreate from IMAGE : ")

        imageView = findViewById(R.id.imageView)
        val imagePath = intent.getStringExtra("image_path")

        if (imagePath == null) {
            Toast.makeText(this, "No image path provided", Toast.LENGTH_SHORT).show()
            return
        }

        try {
            val file = File(imagePath)

            val bitmap = BitmapFactory.decodeFile(file.absolutePath)
            imageView.setImageBitmap(bitmap)

        } catch (e: Exception) {
            Toast.makeText(this, "Error loading image", Toast.LENGTH_SHORT).show()
        }
    }
}