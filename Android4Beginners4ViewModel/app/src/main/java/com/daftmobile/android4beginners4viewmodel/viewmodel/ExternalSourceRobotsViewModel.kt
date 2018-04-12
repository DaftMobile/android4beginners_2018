package com.daftmobile.android4beginners4viewmodel.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Transformations
import android.arch.lifecycle.ViewModel
import com.daftmobile.android4beginners4viewmodel.log
import com.daftmobile.android4beginners4viewmodel.model.Robot
import com.daftmobile.android4beginners4viewmodel.model.RobotDataSource
import com.daftmobile.android4beginners4viewmodel.model.RobotGenerator


class ExternalSourceRobotsViewModel: ViewModel(), RobotDataSource.Observer {

    private val mutableLiveData: MutableLiveData<String> = MutableLiveData()
    private val robotDataSource = RobotDataSource()

    init {
        robotDataSource.observer = this
    }

    fun getItems(): LiveData<String> = mutableLiveData

    fun addItem() = robotDataSource.addNew()

    override fun onChanged(robotDataSource: RobotDataSource) {
        mutableLiveData.value = robotDataSource.getRobots().toString()
    }

    override fun onCleared() {
        robotDataSource.observer = null
        log("Cleared")
    }

//    fun sort() {
//        val temp = mutableLiveData.value ?: emptyList()
//        mutableLiveData.value = temp.sortedBy { it.name }
//    }
}