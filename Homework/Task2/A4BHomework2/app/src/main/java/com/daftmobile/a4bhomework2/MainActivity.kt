package com.daftmobile.a4bhomework2

import android.net.Uri
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private fun retrieveEmailFromContactUri(uri: Uri): String {
        val projection = arrayOf(CommonDataKinds.Email.ADDRESS)
        val cursor = contentResolver.query(uri, projection, null, null, null)
        return if (cursor != null && cursor.moveToFirst()) {
            val columnIndex = cursor.getColumnIndex(CommonDataKinds.Phone.NUMBER)
            val address = cursor.getString(columnIndex)
            cursor.close()
            address
        }
        else {
            ""
        }
    }

    companion object {
        private const val REQUEST_SELECT_CONTACT = 102
    }
}
