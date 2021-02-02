package com.meicet.adapter

object BaseConfig {
    var debug=BuildConfig.DEBUG
    @JvmStatic
    var onClickTimeDebouncing=200L

    fun openDebug(debug:Boolean){
        this.debug=debug
    }
    //一页多少条数据
    var PageSize=15
    //第一页从1开始
    var PageFirst=1
}