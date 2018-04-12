package com.daftmobile.android4beginners4viewmodel.model


class RobotDataSource {
    private val robots = mutableListOf<Robot>()
    var observer: Observer? = null

    fun getRobots() = robots.toList()

    fun addNew(robot: Robot = RobotGenerator.generate()) {
        robots.add(robot)
        observer?.onChanged(this)
    }

    interface Observer {
        fun onChanged(robotDataSource: RobotDataSource)
    }
}