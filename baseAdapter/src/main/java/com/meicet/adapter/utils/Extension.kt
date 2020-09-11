package com.meicet.adapter.utils


fun String.phoneEncryption(): String {
    if (this.length == 11) {
        return "${substring(0, 3)}****${substring(7, 11)}"
    } else {
        return ""
    }

}

fun Int.format2() = String.format("%02d", this)
fun Float.format1() = String.format("%.1f", this)
fun Float.format2() = String.format("%.2f", this)
fun Double.format1() = String.format("%.1f", this)
fun Double.format2() = String.format("%.2f", this)
fun Double.percent() = String.format("%.1f", this) + " %"



