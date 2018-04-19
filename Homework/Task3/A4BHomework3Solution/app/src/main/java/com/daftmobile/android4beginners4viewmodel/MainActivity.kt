package com.daftmobile.android4beginners4viewmodel

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.daftmobile.android4beginners4viewmodel.viewmodel.ExternalSourceRobotsViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: ExternalSourceRobotsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this)
                .get(ExternalSourceRobotsViewModel::class.java)
        viewModel.getItems().observe(this, Observer {
            items.text = it
        })

        fab.setOnClickListener {
            addNewItem()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.sortAscending -> sortAscending()
            R.id.sortDescending -> sortDescending()
            else -> return false
        }
        return true
    }

    private fun addNewItem() = viewModel.addItem()

    private fun sortAscending() = viewModel.sortAscending()

    private fun sortDescending() = viewModel.sortDescending()
}
