package com.daftmobile.android4beginners4

import android.arch.lifecycle.MutableLiveData
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager


class LuminosityLiveData(private val sensorManager: SensorManager): MutableLiveData<Luminosity>() {
    private val lightSensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT)

    override fun onActive() {
        log("I have an observer!")
        sensorManager.registerListener(sensorListener, lightSensor, SensorManager.SENSOR_DELAY_UI)
    }

    override fun onInactive() {
        log("I lost all observers! Sleep...")
        sensorManager.unregisterListener(sensorListener)
    }

    private val sensorListener = object : SensorEventListener {
        override fun onAccuracyChanged(sensor: Sensor, accuracy: Int) = Unit

        override fun onSensorChanged(event: SensorEvent) {
            value = Luminosity(event.values[0])
        }
    }
}