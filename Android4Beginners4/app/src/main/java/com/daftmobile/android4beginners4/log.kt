package com.daftmobile.android4beginners4

import android.util.Log

/**
 * Created by Konrad Kowalewski on 08.04.18.
 */
fun Any.log(message: String) = Log.d(javaClass.simpleName, message)