package com.example.day1.activity1.view

import com.example.day1.model.remote.Product

interface Communicator {
    fun ShowProductDetails(it: Product)
}