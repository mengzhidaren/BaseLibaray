package com.meicet.adapter.view

import android.view.View

interface StatusListener {

    fun setCallBackStatus(callBack: OnCallBackStatus)

    fun getEmptyView():View


    fun showEmpty(info: String="")
    fun showLoading(info: String="")
    fun showError(info: String="")

    interface OnCallBackStatus {
        fun onClickError(statusEmpty:Boolean)
    }

}

