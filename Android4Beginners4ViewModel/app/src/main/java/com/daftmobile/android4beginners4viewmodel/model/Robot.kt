package com.daftmobile.android4beginners4viewmodel.model


data class Robot(val id: Int, val name: String, val mood: Mood) {
    override fun toString() = "${mood.name.toLowerCase()} $name"

    enum class Mood { HAPPY, SAD }
}