package com.meicet.adapter.utils

object CheckTextUtils {

    @JvmStatic
    fun checkEmails(emailText: String): Boolean {
        val regex = Regex("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*")
        return regex.matches(emailText)
    }

}