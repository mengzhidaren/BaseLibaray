package com.meicet.adapter

object BaseConfig {
    var debug=BuildConfig.DEBUG
    @JvmStatic
    var onClickTimeDebouncing=200L

    fun openDebug(debug:Boolean){
        this.debug=debug
    }
}