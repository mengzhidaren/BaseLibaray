package com.meicet.adapter.adapter

open class BasePageInfo {

    val PAGE_SIZE = 10

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