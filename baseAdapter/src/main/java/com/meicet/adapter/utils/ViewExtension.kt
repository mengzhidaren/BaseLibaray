package com.meicet.adapter.utils

import android.view.View
import com.blankj.utilcode.util.ClickUtils
import com.blankj.utilcode.util.ToastUtils


//对全局的点击按键有效

fun View.onClickOnce(listener: (view: View) -> Unit) {
    //1秒内避免连续点击
    ClickUtils.applyGlobalDebouncing(this, 1000) {
        listener.invoke(it)
    }
}

//对单一的按键有效
fun View.onClickOnceSingle(listener: (view: View) -> Unit) {
    ClickUtils.applySingleDebouncing(this, 1000) {
        listener.invoke(it)
    }
}

fun View.visiableState(): Boolean {
    return visibility == View.VISIBLE
}

fun View.visiable(visiable: Boolean) {
    visibility = if (visiable) View.VISIBLE else View.INVISIBLE
}

fun View.gone(gone: Boolean) {
    if (gone && visibility != View.GONE) {
        visibility = View.GONE
    } else if (!gone && visibility != View.VISIBLE) {
        visibility = View.VISIBLE
    }
}

fun toast(msg: String) {
    ToastUtils.showShort(msg)
}

fun toastL(msg: String) {
    ToastUtils.showLong(msg)
}
