package com.daftmobile.android4beginners2

import android.util.Log


fun Any.log(message: String) {
    Log.d(javaClass.simpleName, message)
}