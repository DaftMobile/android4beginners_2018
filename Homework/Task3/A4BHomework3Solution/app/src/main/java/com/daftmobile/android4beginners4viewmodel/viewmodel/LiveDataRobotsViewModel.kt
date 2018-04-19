package com.daftmobile.android4beginners4viewmodel.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Transformations
import android.arch.lifecycle.ViewModel
import com.daftmobile.android4beginners4viewmodel.model.Robot
import com.daftmobile.android4beginners4viewmodel.model.RobotGenerator


class LiveDataRobotsViewModel: ViewModel() {
    private val mutableLiveData: MutableLiveData<List<Robot>> = MutableLiveData()

    fun getItems(): LiveData<String> = Transformations.map(mutableLiveData, { list: List<Robot>? -> list?.toString() })

    fun addItem() {
        val temp = mutableLiveData.value ?: emptyList()
        val mutableList = temp.toMutableList()
        mutableList.add(RobotGenerator.generate())
        mutableLiveData.value = mutableList
    }

//    fun sort() {
//        val temp = mutableLiveData.value ?: emptyList()
//        mutableLiveData.value = temp.sortedBy { it.name }
//    }
}