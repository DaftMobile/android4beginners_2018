package com.daftmobile.android4beginners4


data class Luminosity(val lux: Float) {
    val percentageOfIndoorLight = lux/1200f
}