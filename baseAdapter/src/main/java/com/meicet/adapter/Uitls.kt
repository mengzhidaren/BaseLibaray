package com.meicet.adapter

import android.view.View



fun View._gone(gone:Boolean){
    if(gone&&visibility!= View.GONE){
        visibility= View.GONE
    }else if(!gone&&visibility!= View.VISIBLE){
        visibility= View.VISIBLE
    }
}

fun View._visiable(visiable: Boolean) {
    if (visiable && visibility != View.VISIBLE) {
        visibility = View.VISIBLE
    } else if (!visiable && visibility != View.INVISIBLE) {
        visibility = View.INVISIBLE
    }
}
