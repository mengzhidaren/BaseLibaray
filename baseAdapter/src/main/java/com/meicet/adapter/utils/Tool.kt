package com.meicet.adapter.utils

import com.blankj.utilcode.util.NetworkUtils


fun checkNetWork()= NetworkUtils.isWifiConnected()

fun checkNetWorkToast():Boolean{
 val connect=   NetworkUtils.isWifiConnected()
    if(!connect){
        toast("请检查网络")
    }
    return connect
}


fun checkEmails(emailText:String):Boolean{
    val regex= Regex("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*")
    return regex.matches(emailText)
}