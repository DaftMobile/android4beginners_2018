package com.daftmobile.android4beginners3intents

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*


class MainActivity : AppCompatActivity() {

    private val items = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showColorButton.setOnClickListener(this::showColorActivity)

        fab.setOnClickListener(this::showAddActivity)
    }

    override fun onResume() {
        super.onResume()
        reloadItems()
    }

    private fun reloadItems() {
        itemsView.text = items.toString()
    }

    private fun showColorActivity(view: View) {
        // tutaj otwórz ColorActivity
    }

    private fun showAddActivity(view: View) {
        // tutaj otwórz AddActivity
    }

    private object RandomColor {
        private val random = Random()

        fun generate(): Int = Color.rgb(random.nextInt(255), random.nextInt(255), random.nextInt(255))
    }
}
