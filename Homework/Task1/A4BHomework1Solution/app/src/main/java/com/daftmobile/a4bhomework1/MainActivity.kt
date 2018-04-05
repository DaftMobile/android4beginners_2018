package com.daftmobile.a4bhomework1

import android.app.Activity
import android.app.AlertDialog
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        checkButton.setOnClickListener(this::validateEmail)
    }

    private fun validateEmail(view: View) {
        val input = emailInput.editableText.toString()
        if (EmailValidator.isValidEmail(input)) {
            showOkDialog()
        } else {
            showAlertDialog()
        }
    }

    private fun showAlertDialog() {
        AlertDialog.Builder(this)
                .setMessage(R.string.invalid_email_message)
                .setPositiveButton(R.string.keep_button_label, null)
                .setNegativeButton(R.string.clear_button_label, { _, _ -> emailInput.setText("") })
                .show()
    }

    private fun showOkDialog() {
        AlertDialog.Builder(this)
                .setMessage(R.string.valid_email_message)
                .setPositiveButton(android.R.string.ok, null)
                .show()
    }
}
