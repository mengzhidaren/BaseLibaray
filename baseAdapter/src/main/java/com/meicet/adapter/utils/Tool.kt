package com.meicet.adapter.utils

import com.blankj.utilcode.util.NetworkUtils

object Tool{
    @JvmStatic
    fun checkNetWork()= NetworkUtils.isWifiConnected()
    @JvmStatic
    fun checkNetWorkToast():Boolean{
        val connect=   NetworkUtils.isWifiConnected()
        if(!connect){
            toast("请检查网络")
        }
        return connect
    }

    @JvmStatic
    fun checkEmails(emailText:String):Boolean{
        val regex= Regex("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*")
        return regex.matches(emailText)
    }
}
