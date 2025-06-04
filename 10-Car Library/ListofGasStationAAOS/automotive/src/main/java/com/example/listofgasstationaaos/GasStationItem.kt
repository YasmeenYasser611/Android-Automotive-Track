package com.example.listofgasstationaaos

import androidx.car.app.CarContext
import androidx.car.app.Screen
import androidx.car.app.model.Action
import androidx.car.app.model.ActionStrip
import androidx.car.app.model.CarIcon
import androidx.car.app.model.Pane
import androidx.car.app.model.PaneTemplate
import androidx.car.app.model.Row
import androidx.car.app.model.Template
import androidx.core.graphics.drawable.IconCompat

class GasStationItem(context: CarContext, private val id: Int) : Screen(context) {
    override fun onGetTemplate(): Template {
        val gasStation = when (id) {
            1 -> GasStation(
                id = 1,
                title = "Chillout",
                imageResId = R.drawable.one,
                distance = "0.5 mi",
                address = "Cairo",
                fuelTypes = "Regular, Premium, Diesel",
                hours = "Open 24/7"
            )
            2 -> GasStation(
                id = 2,
                title = "Master Gas",
                imageResId = R.drawable.two,
                distance = "0.7 mi",
                address = "6 oct city",
                fuelTypes = "Regular, Diesel",
                hours = "6 AM - 10 PM"
            )
            3 -> GasStation(
                id = 3,
                title = "National Petroleum",
                imageResId = R.drawable.three,
                distance = "0.8 mi",
                address = " Alex",
                fuelTypes = "Regular, Premium",
                hours = "7 AM - 11 PM"
            )
            4 -> GasStation(
                id = 4,
                title = "Misr Petroleum",
                imageResId = R.drawable.four,
                distance = "0.9 mi",
                address = "Giza",
                fuelTypes = "Regular, Premium, Diesel",
                hours = "Open 24/7"
            )
            5 -> GasStation(
                id = 5,
                title = "Mobil Petrol Station",
                imageResId = R.drawable.five,
                distance = "1.1 mi",
                address = "ain shams",
                fuelTypes = "Regular, Premium",
                hours = "5 AM - 12 AM"
            )
            else -> GasStation(
                id = -1,
                title = "Unknown Station",
                imageResId = R.drawable.ic_launcher_background,
                distance = "N/A",
                address = "Unknown Address",
                fuelTypes = "N/A",
                hours = "N/A"
            )
        }

        val iconCompat = IconCompat.createWithResource(carContext, gasStation.imageResId)
        val carIcon = CarIcon.Builder(iconCompat).build()

        val distanceRow = Row.Builder()
            .setTitle("Distance")
            .addText(gasStation.distance)
            .build()

        val addressRow = Row.Builder()
            .setTitle("Address")
            .addText(gasStation.address)
            .build()

        val fuelRow = Row.Builder()
            .setTitle("Fuel Types")
            .addText(gasStation.fuelTypes)
            .build()

        val hoursRow = Row.Builder()
            .setTitle("Hours")
            .addText(gasStation.hours)
            .build()

        val pane = Pane.Builder()
            .setImage(carIcon)
            .addRow(distanceRow)
            .addRow(addressRow)
            .addRow(fuelRow)
            .addRow(hoursRow)
            .build()

        val backAction = Action.Builder()
            .setIcon(CarIcon.BACK)
            .setOnClickListener { screenManager.pop() }
            .build()

        val actionStrip = ActionStrip.Builder()
            .addAction(backAction)
            .build()

        return PaneTemplate.Builder(pane)
            .setTitle(gasStation.title)
            .setActionStrip(actionStrip)
            .build()
    }
}