package com.meicet.adapter.view

interface Refreshable{
    fun setOnRefresh(callback: CallBack?)
    fun finishRefresh()
    interface CallBack {
        fun onRefresh()
    }

    interface CallBackMore {
        fun onLoadMore()
    }

}