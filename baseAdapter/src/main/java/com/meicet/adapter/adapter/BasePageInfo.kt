package com.meicet.adapter.adapter

import com.meicet.adapter.BaseConfig

open class BasePageInfo {
    //请求数据数量
    var pageSize = BaseConfig.PageSize
    //滑到底后 是否隐藏加载更多的数量
    var showPageSize = pageSize

    var page = BaseConfig.PageFirst

    fun nextPage() {
        page++
    }

    fun reset() {
        page = BaseConfig.PageFirst
    }

    fun isFirstPage()=page == BaseConfig.PageFirst
}