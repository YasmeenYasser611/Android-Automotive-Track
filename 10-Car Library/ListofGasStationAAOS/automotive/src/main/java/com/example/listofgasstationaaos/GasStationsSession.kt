package com.example.listofgasstationaaos

import android.content.Intent
import androidx.car.app.Screen
import androidx.car.app.Session

class GasStationsSession:Session() {
    override fun onCreateScreen(intent: Intent): Screen {
        return GasStationsListScreen(carContext)
    }
}