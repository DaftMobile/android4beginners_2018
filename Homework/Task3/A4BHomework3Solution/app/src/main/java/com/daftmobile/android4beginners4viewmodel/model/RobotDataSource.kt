package com.daftmobile.android4beginners4viewmodel.model

import java.util.*


class RobotDataSource {
    private val ascendingComp: Comparator<Robot> = Comparator { robot1, robot2 -> robot1.name.compareTo(robot2.name) }
    private val descendingComp: Comparator<Robot> = Comparator { robot1, robot2 -> robot2.name.compareTo(robot1.name) }
    private val robots = mutableListOf<Robot>()
    private var comparator: Comparator<Robot>? = null
    var observer: Observer? = null

    fun getRobots() = robots.toList()

    fun addNew(robot: Robot = RobotGenerator.generate()) {
        robots.add(robot)
        rearrangeAndNotify()
    }

    fun sortAscending() {
        comparator = ascendingComp
        rearrangeAndNotify()
    }

    fun sortDescending() {
        comparator = descendingComp
        rearrangeAndNotify()
    }

    private fun rearrangeAndNotify() {
        val comparator = comparator
        if (comparator != null) robots.sortWith(comparator)
        observer?.onChanged(this)
    }

    interface Observer {
        fun onChanged(robotDataSource: RobotDataSource)
    }
}