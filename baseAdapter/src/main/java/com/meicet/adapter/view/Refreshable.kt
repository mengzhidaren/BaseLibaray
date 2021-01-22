package com.meicet.adapter.view

interface Refreshable{
    fun setOnRefresh(callback: CallBack?)
    fun setOnRefreshTime(callback: CallBack?,lockTime:Long)
    fun finishRefresh()
    interface CallBack {
        fun onRefresh()
    }

    interface CallBackMore {
        fun onLoadMore()
    }

}