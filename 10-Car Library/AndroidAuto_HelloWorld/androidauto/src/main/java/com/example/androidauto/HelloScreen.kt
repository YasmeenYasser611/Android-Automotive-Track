package com.example.androidauto

import android.util.Log
import androidx.car.app.CarContext
import androidx.car.app.Screen
import androidx.car.app.model.MessageTemplate
import androidx.car.app.model.Template
import kotlin.math.log

class HelloScreen(context: CarContext) : Screen(context) {
    override fun onGetTemplate(): Template {
        Log.i("TAG", "onGetTemplate: ")
        return MessageTemplate.Builder("Hi, Yasmeen From Android Auto").build()
    }
}