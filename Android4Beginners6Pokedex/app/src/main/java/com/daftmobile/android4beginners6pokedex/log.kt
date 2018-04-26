package com.daftmobile.android4beginners6pokedex

import android.util.Log

/**
* Created by Konrad Kowalewski.
*/
fun Any.log(message: String?) = Log.d(javaClass.simpleName, message ?: "null message")