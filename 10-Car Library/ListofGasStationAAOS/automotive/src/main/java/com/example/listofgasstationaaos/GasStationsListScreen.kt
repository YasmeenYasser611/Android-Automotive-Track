package com.example.listofgasstationaaos

import androidx.car.app.CarContext
import androidx.car.app.Screen
import androidx.car.app.model.CarIcon
import androidx.car.app.model.ItemList
import androidx.car.app.model.ListTemplate
import androidx.car.app.model.Row
import androidx.car.app.model.Template
import androidx.car.app.navigation.model.MapWithContentTemplate
import androidx.car.app.annotations.ExperimentalCarApi
import androidx.core.graphics.drawable.IconCompat

class GasStationsListScreen(context: CarContext) : Screen(context) {
    @androidx.annotation.OptIn(ExperimentalCarApi::class)
    override fun onGetTemplate(): Template {
        val gasStations = listOf(
            GasStation(
                id = 1,
                title = "Chillout",
                imageResId = R.drawable.one,
                distance = "0.5 mi",
                address = "Cairo",
                fuelTypes = "Regular, Premium, Diesel",
                hours = "Open 24/7"
            ),
            GasStation(
                id = 2,
                title = "Master Gas",
                imageResId = R.drawable.two,
                distance = "0.7 mi",
                address = "6 oct city",
                fuelTypes = "Regular, Diesel",
                hours = "6 AM - 10 PM"
            ),
            GasStation(
                id = 3,
                title = "National Petroleum",
                imageResId = R.drawable.three,
                distance = "0.8 mi",
                address = "Alex",
                fuelTypes = "Regular, Premium",
                hours = "7 AM - 11 PM"
            ),
            GasStation(
                id = 4,
                title = "Misr Petroleum",
                imageResId = R.drawable.four,
                distance = "0.9 mi",
                address = "Giza",
                fuelTypes = "Regular, Premium, Diesel",
                hours = "Open 24/7"
            ),
            GasStation(
                id = 5,
                title = "Mobil Petrol Station",
                imageResId = R.drawable.five,
                distance = "1.1 mi",
                address = "ain shams",
                fuelTypes = "Regular, Premium",
                hours = "5 AM - 12 AM"
            )
        )

        val itemListBuilder = ItemList.Builder()
        gasStations.forEach { gasStation ->
            val iconCompat = IconCompat.createWithResource(carContext, gasStation.imageResId)
            val carIcon = CarIcon.Builder(iconCompat).build()
            val row = Row.Builder()
                .setImage(carIcon)
                .setTitle(gasStation.title)
                .addText(gasStation.distance)
                .setOnClickListener { screenManager.push(GasStationItem(carContext, gasStation.id)) }
                .build()
            itemListBuilder.addItem(row)
        }

        val listTemplate = ListTemplate.Builder()
            .setSingleList(itemListBuilder.build())
            .setTitle("Your nearest Gas Stations")
            .build()


        return MapWithContentTemplate.Builder()
            .setContentTemplate(listTemplate)
            .build()

    }
}