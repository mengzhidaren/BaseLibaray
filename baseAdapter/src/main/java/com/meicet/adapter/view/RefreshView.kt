package com.meicet.adapter.view

import android.content.Context
import android.util.AttributeSet
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout

class RefreshView : SwipeRefreshLayout, Refreshable {
    private var lastTime: Long = 0


    override fun setOnRefresh(callback: Refreshable.CallBack?) {
        setOnRefreshListener {
            callback?.onRefresh()
        }
    }

    //锁定刷新时间
    override fun setOnRefreshTime(callback: Refreshable.CallBack?, lockTime: Long) {
        setOnRefreshListener {
            if (getOffTime() >= lockTime) {
                callback?.onRefresh()
                updateTime()
            } else {
                finishRefresh()
            }
        }
    }


    override fun finishRefresh() {
        isRefreshing = false
    }

    private fun getOffTime(): Long {
        return System.currentTimeMillis() - lastTime
    }

    private fun updateTime() {
        lastTime = System.currentTimeMillis()
    }

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)


}