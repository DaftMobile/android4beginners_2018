package com.daftmobile.a4bhomework2solution

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        chooseContactButton.setOnClickListener(this::onContactButtonClicked)
        sendMailButton.setOnClickListener(this::onMailButtonClicked)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQUEST_SELECT_CONTACT && resultCode == Activity.RESULT_OK) {
            val uri = data?.data ?: return
            emailView.text = retrieveEmailFromContactUri(uri)
        }
    }

    private fun onContactButtonClicked(view: View) = selectContact()

    private fun selectContact() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = CommonDataKinds.Email.CONTENT_TYPE
        if (intent.resolveActivity(packageManager) != null) {
            startActivityForResult(intent, REQUEST_SELECT_CONTACT)
        }
    }

    private fun onMailButtonClicked(view: View) = composeEmail(
            arrayOf(emailView.text.toString()),
            getString(R.string.email_subject)
    )

    private fun composeEmail(addresses: Array<String>, subject: String) {
        val intent = Intent(Intent.ACTION_SENDTO)
        intent.data = Uri.parse("mailto:")
        intent.putExtra(Intent.EXTRA_EMAIL, addresses)
        intent.putExtra(Intent.EXTRA_SUBJECT, subject)
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }

    private fun retrieveEmailFromContactUri(uri: Uri): String {
        val projection = arrayOf(CommonDataKinds.Email.ADDRESS)
        val cursor = contentResolver.query(uri, projection, null, null, null)
        if (cursor != null && cursor.moveToFirst()) {
            val columnIndex = cursor.getColumnIndex(CommonDataKinds.Phone.NUMBER)
            val address = cursor.getString(columnIndex)
            cursor.close()
            return address
        }
        else {
            return ""
        }
    }

    companion object {
        private const val REQUEST_SELECT_CONTACT = 102
    }
}
