package com.example.listofgasstationaaos

data class GasStation(
    val id: Int,
    val title: String,
    val imageResId: Int,
    val distance: String,
    val address: String,
    val fuelTypes: String,
    val hours: String
)