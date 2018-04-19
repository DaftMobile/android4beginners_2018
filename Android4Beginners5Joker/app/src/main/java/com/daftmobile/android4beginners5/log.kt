package com.daftmobile.android4beginners5

import android.util.Log

/**
 * Created by Konrad Kowalewski on 17.04.18.
 */
fun Any.log(message: String?) = Log.d(javaClass.simpleName, message ?: "null message")