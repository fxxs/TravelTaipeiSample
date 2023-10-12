package com.example.traveltaipei

import android.util.Log

fun Any?.log(tag: String = "tomtom", lv: Int = 1): Any? {
    if (BuildConfig.DEBUG) when (lv) {
        0 -> {
            Log.v(tag, toString())
        }

        1 -> {
            Log.d(tag, toString())
        }

        2 -> {
            Log.i(tag, toString())
        }

        3 -> {
            Log.w(tag, toString())
        }

        4 -> {
            Log.e(tag, toString())
        }
    }
    return this
}