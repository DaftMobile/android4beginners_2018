package com.daftmobile.android4beginners3intents

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_add.*

class AddActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
        addButton.setOnClickListener(this::onCloseButtonClicked)
    }

    private fun onCloseButtonClicked(view: View) {
        // set result
        // finish
    }

    companion object {
        const val RESULT_KEY = "result_key"
    }
}
