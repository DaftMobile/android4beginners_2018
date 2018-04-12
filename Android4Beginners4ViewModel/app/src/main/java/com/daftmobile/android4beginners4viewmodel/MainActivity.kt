package com.daftmobile.android4beginners4viewmodel

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.daftmobile.android4beginners4viewmodel.viewmodel.SimpleRobotsViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: SimpleRobotsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = SimpleRobotsViewModel()
        reloadItems()

        fab.setOnClickListener {
            addNewItem()
        }
    }

    private fun addNewItem() {
        viewModel.addItem()
        reloadItems()
    }

    private fun reloadItems() {
        items.text = viewModel.getItems().toString()
    }
}
