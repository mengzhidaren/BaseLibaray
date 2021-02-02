package com.meicet.adapter.adapter

import com.meicet.adapter.BaseConfig

open class BasePageInfo {

    var pageSize = BaseConfig.PageSize
    var showPageSize = pageSize

    var page = 1

    fun nextPage() {
        page++
    }

    fun reset() {
        page = 1
    }

    fun isFirstPage()=page == 1
}