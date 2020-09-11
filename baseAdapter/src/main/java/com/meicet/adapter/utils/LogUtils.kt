package com.meicet.adapter.utils

import android.util.Log
import com.meicet.adapter.BaseConfig


fun _i(tag: String, msg: String) {
    if (BaseConfig.debug)
        Log.i(tag, msg)
}

fun _i(msg: String) {
    if (BaseConfig.debug)
        Log.i("yyl", msg)
}

fun _i(error: Exception) {
    if (BaseConfig.debug)
        error.printStackTrace()
}

fun _ee(error: String) {
    if (BaseConfig.debug)
        Log.e("yyl", "发生了不可能的错误 $error")
}

fun _e(error: String) {
    if (BaseConfig.debug)
        Log.e("yyl", "发生了不可能的错误 $error")
}

fun _e(error: Exception) {
    if (BaseConfig.debug)
        error.printStackTrace()
    // LogUtils.e(error)
}





