package com.meicet.adapter.adapter

import androidx.annotation.LayoutRes

/**
 * 没有自动加载更多的adapter
 * 只请求一次接口的列表数据
 */
abstract class BaseTAdapter<T>(@LayoutRes layoutID: Int = 0, list: MutableList<T>? = null) :
    BaseRefreshAdapter<T>(layoutID, list) {


    //有headerView时但没有数据---是否显示空布局
    var headerBottomShowEmptyLayout = false


    var onCallRequestPage: () -> Unit = {}


    //下拉刷新回调接口
    override fun onPullRefresh() {
        refreshUI()
    }


    //重新从第一页开始请求
    fun refreshUI(clear: Boolean = false) {
        if (clear) {
            setNewInstance(null)
        }
        statusView?.showLoading()
        onCallRequestPage.invoke()
    }

    //请求成功一页
    fun loadPage(list: List<T>?) {
        onRefreshFinish()
        if (list == null || list.isEmpty()) {
            isUseEmpty = !(hasHeaderLayout() && !headerBottomShowEmptyLayout)
            statusView?.showEmpty()
            setNewInstance(null)
        } else {
            setNewInstance(list.toMutableList())
        }
    }

    //请求失败
    fun loadPageError(error: String) {
        setNewInstance(null)
        onRefreshFinish()
        statusView?.showError(error)
    }

    init {
        //空数据时是否显示 header
        headerWithEmptyEnable = true
    }
}