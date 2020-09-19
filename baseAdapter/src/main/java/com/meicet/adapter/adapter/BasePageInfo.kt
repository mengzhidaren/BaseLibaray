package com.meicet.adapter.adapter

open class BasePageInfo {

    var pageSize = 10
    var showPageSize = pageSize

    var page = 1

    fun nextPage() {
        page++
    }

    fun reset() {
        page = 1
    }

    val isFirstPage: Boolean
        get() = page == 1
}