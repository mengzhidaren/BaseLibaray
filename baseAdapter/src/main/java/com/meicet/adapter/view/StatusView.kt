package com.meicet.adapter.view

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import com.meicet.adapter.R
import com.meicet.adapter.utils.gone
import kotlinx.android.synthetic.main._status_view.view.*

class StatusView(context: Context, attr: AttributeSet?) : FrameLayout(context, attr),
    StatusListener {
    constructor(context: Context) : this(context, null)

    private val status_empty = 1
    private val status_loading = 2
    private val status_error = 3
    private var currentState = status_empty

    var onCallback= object : StatusListener.OnCallBackStatus {
        override fun onClickError(statusEmpty:Boolean) {

        }
    }

    init {
        View.inflate(context, R.layout._status_view, this)
        setOnClickListener {
            if (currentState == status_error) {
                onCallback.onClickError(currentState == status_empty)
            }
        }
    }

    override fun setCallBackStatus(callBack: StatusListener.OnCallBackStatus) {
        this.onCallback = callBack
    }

    override fun getEmptyView()=this



    fun setEmptyText(info: String) {
        emptyInfo.text = info
    }

    fun setErrorText(info: String) {
        errorInfo.text = info
    }

    fun setLoadText(info: String) {
        loadInfo.text = info
    }

    fun setTextColor(colorText: Int) {
        emptyInfo.setTextColor(colorText)
        errorInfo.setTextColor(colorText)
        loadInfo.setTextColor(colorText)
    }


    override fun showEmpty(info: String) {
        currentState = status_empty
        if (info.isNotEmpty()) {
            emptyInfo.text = info
        }
        refreshView()
    }

    override fun showLoading(info: String) {
        currentState = status_loading
        if (info.isNotEmpty()) {
            loadInfo.text = info
        }
        refreshView()
    }

    override fun showError(info: String) {
        currentState = status_error
        if (info.isNotEmpty()) {
            errorInfo.text = info
        }
        refreshView()
    }

    private fun refreshView() {

        emptyView.gone(currentState != status_empty)
        loadView.gone(currentState != status_loading)
        errorView.gone(currentState != status_error)
    }



}