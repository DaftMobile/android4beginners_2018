package com.daftmobile.android4beginners4viewmodel.viewmodel

import android.arch.lifecycle.ViewModel
import com.daftmobile.android4beginners4viewmodel.model.Robot
import com.daftmobile.android4beginners4viewmodel.model.RobotGenerator

class SimpleRobotsViewModel: ViewModel() {
    private val items = mutableListOf<Robot>()

    fun getItems(): List<Robot> {
        return items
    }

    fun addItem() {
        items.add(RobotGenerator.generate())
    }
}