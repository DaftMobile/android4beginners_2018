package com.daftmobile.android4beginners4viewmodel.model

import java.util.*


object RobotGenerator {
    private val names = listOf(
            "BB8",
            "R2-D2",
            "C-3PO",
            "IG-88",
            "IG-100",
            "Wall-e",
            "Curiosity",
            "Opportunity",
            "Pathfinder",
            "Spirit"
    )

    private var index = 0

    private val random = Random()

    fun generate(): Robot = Robot(index++, names[random.nextInt(names.size)], Robot.Mood.values()[random.nextInt(2)])
}