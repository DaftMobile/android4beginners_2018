package com.daftmobile.android4beginners4

import android.arch.lifecycle.Observer
import android.content.Context
import android.graphics.Color
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private lateinit var sensorManager: SensorManager
    private lateinit var sensor: Sensor

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT)
    }

    private fun updateView(luminosity: Luminosity?) {
        if (luminosity == null) return
        luxView.text = luminosity.lux.toString()
        colorView.setBackgroundColor(Color.HSVToColor(floatArrayOf(50f, 0.5f, luminosity.percentageOfIndoorLight)))
    }

    override fun onStart() {
        super.onStart()
        sensorManager.registerListener(listener, sensor, SensorManager.SENSOR_DELAY_UI)
    }

    override fun onStop() {
        super.onStop()
        sensorManager.unregisterListener(listener)
    }

    private val listener = object : SensorEventListener {
        override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) = Unit

        override fun onSensorChanged(event: SensorEvent) {
            log(event.toString())
            val luminosity = Luminosity(event.values[0])
            updateView(luminosity)
        }
    }

    // LIVE DATA

    private fun initLiveData() {
        val sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager

        LuminosityLiveData(sensorManager).observe(this, Observer {
            updateView(it)
        })
    }

}
