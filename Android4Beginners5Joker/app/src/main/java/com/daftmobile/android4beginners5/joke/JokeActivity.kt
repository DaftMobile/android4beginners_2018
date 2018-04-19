package com.daftmobile.android4beginners5.joke

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.daftmobile.android4beginners5.R
import com.daftmobile.android4beginners5.log
import kotlinx.android.synthetic.main.activity_joke.*

class JokeActivity : AppCompatActivity() {

    private lateinit var jokeViewModel: JokeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_joke)

        jokeViewModel = ViewModelProviders.of(this).get(JokeViewModel::class.java)

        observeResponses()

        callButton.setOnClickListener {
//            Thread {
//                Thread.sleep(5000)
//                log("I woke up")
//            }.start()
        }
    }

    private fun observeResponses() {
        jokeViewModel.response().observe(this, Observer {
            jokeView.text = it
        })
    }

    private fun observeErrors() {
        jokeViewModel.error().observe(this, Observer {
            AlertDialog.Builder(this)
                    .setTitle(R.string.error)
                    .setMessage(it)
                    .show()
        })
    }

    private fun observeLoader() {
        jokeViewModel.loaderVisible().observe(this, Observer {
            loader.visibility = if (it == true) View.VISIBLE else View.GONE
        })
    }
}
