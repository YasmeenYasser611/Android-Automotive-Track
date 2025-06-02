package com.example.day2_locatione

import android.Manifest
import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Geocoder
import android.location.LocationManager
import android.net.Uri
import android.os.Bundle
import android.os.Looper
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresPermission
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.motion.widget.Debug.getLocation
import androidx.core.app.ActivityCompat
import androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
import com.google.android.gms.common.api.GoogleApi.Settings

import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationResult
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.Priority
import java.util.Locale

const  val MY_LOCATION_PERMISSION_ID = 123
const val SMS_PERMISSION_REQUEST_CODE = 456

class MainActivity : AppCompatActivity()
{
    lateinit var tvLatitude :TextView
    lateinit var tvLongitude :TextView
    lateinit var tvLoaction :TextView
    lateinit var btnSMS : Button
    lateinit var btnLocation :Button

    var address :String=""

    lateinit var fusedclient :FusedLocationProviderClient
//    private lateinit var locationCallback: LocationCallback

    lateinit var geocoder: Geocoder

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        initUI()
        btnSMS.setOnClickListener {
            sendLocationViaSMS()
        }
        btnLocation.setOnClickListener {
            val latitude = tvLatitude.text.toString().toDoubleOrNull() ?: 0.0
            val longitude = tvLongitude.text.toString().toDoubleOrNull() ?: 0.0

            val intent = Intent(this, MapDisplayActivity::class.java).apply {
                putExtra("LATITUDE", latitude)
                putExtra("LONGITUDE", longitude)
            }
            startActivity(intent)
        }

//
//        val locationRequest = LocationRequest.Builder(0).apply {
//            setPriority(Priority.PRIORITY_HIGH_ACCURACY)
//        }.build()
//
//        locationCallback = object : LocationCallback() {
//            override fun onLocationResult(locationResult: LocationResult)
//            {
//                Log.i(TAG, locationResult.lastLocation.toString())
//            }
//        }
//        if (ActivityCompat.checkSelfPermission(
//                this,
//                Manifest.permission.ACCESS_FINE_LOCATION
//            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
//                this,
//                Manifest.permission.ACCESS_COARSE_LOCATION
//            ) != PackageManager.PERMISSION_GRANTED
//        ) {
//
//            ActivityCompat.requestPermissions(this , arrayOf(Manifest.permission.ACCESS_COARSE_LOCATION ,Manifest.permission.ACCESS_FINE_LOCATION) , MY_LOCATION_PERMISSION_ID)
//            return
//        }


    }



    override fun onStart() {
        super.onStart()
        if(checkPermissions())
        {
            if(isLocationEnable())
            {
                getFreshLocation()
            }
            else
            {
                enableLocationServices()
            }

        }
        else
        {
            ActivityCompat.requestPermissions(this , arrayOf(Manifest.permission.ACCESS_COARSE_LOCATION ,Manifest.permission.ACCESS_FINE_LOCATION) ,MY_LOCATION_PERMISSION_ID )

        }
    }

    private fun initUI() {
        tvLongitude = findViewById(R.id.Longitude)
        tvLatitude = findViewById(R.id.Latitude)
        tvLoaction = findViewById(R.id.Address)
        btnSMS = findViewById(R.id.sms)
        btnLocation = findViewById(R.id.map)
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray, deviceId: Int)
    {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults, deviceId)
        if(requestCode ==MY_LOCATION_PERMISSION_ID )
        {
            if(grantResults[0] == PackageManager.PERMISSION_GRANTED)
            {
                getFreshLocation()
            }

        }
        else if(requestCode ==SMS_PERMISSION_REQUEST_CODE)
        {
            if(grantResults[0] == PackageManager.PERMISSION_GRANTED)
            {
                sendLocationViaSMS()
            }

        }
    }

    fun checkPermissions():Boolean
    {
        return checkSelfPermission(android.Manifest.permission.ACCESS_FINE_LOCATION)== PackageManager.PERMISSION_GRANTED
        checkSelfPermission(android.Manifest.permission.ACCESS_COARSE_LOCATION)== PackageManager.PERMISSION_GRANTED

    }

    @SuppressLint("MissingPermission")
    fun getFreshLocation()
    {
        fusedclient = LocationServices.getFusedLocationProviderClient(this)

        fusedclient.requestLocationUpdates(LocationRequest.Builder(0).apply { setPriority(Priority.PRIORITY_HIGH_ACCURACY) }.build() ,
            object :LocationCallback(){
                override fun onLocationResult(locationResult: LocationResult) {
                    super.onLocationResult(locationResult)
                    val location = locationResult.lastLocation
                    tvLongitude.text= location?.longitude.toString()
                    tvLatitude.text = location?.latitude.toString()
                    geocoder = Geocoder(this@MainActivity, Locale.getDefault())
                    address= geocoder.getFromLocation(location?.latitude?: 0.0, location?.longitude?:0.0, 1)?.get(0).toString()

                    tvLoaction.text = address


                }
            } ,
        Looper.myLooper()
        )

    }

    private  fun enableLocationServices()
    {
        Toast.makeText(this , "Please Turn on Location" , Toast.LENGTH_LONG).show()
        val intent = Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS)
        startActivity(intent)
    }

    private fun isLocationEnable():Boolean
    {
        val locationManager:LocationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager
        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)|| locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)
    }

    private fun sendLocationViaSMS()
    {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.SEND_SMS), SMS_PERMISSION_REQUEST_CODE)
            return
        }

        val message = "My current location:$address"
        val phoneNumber = "01097734891"
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("sms:$phoneNumber"))
        intent.putExtra("sms_body", message)
        startActivity(intent)

    }
}