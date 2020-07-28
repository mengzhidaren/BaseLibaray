package com.meicet.adapter.view

import android.content.Context
import android.util.AttributeSet
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout

class RefreshView : SwipeRefreshLayout, Refreshable {


    override fun setOnRefresh(callback: Refreshable.CallBack?) {
        setOnRefreshListener {
            callback?.onRefresh()
        }
    }

    override fun finishRefresh() {
        isRefreshing = false
    }

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)


}