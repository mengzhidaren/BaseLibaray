package com.meicet.adapter

import android.app.Application
import android.os.Debug
import com.blankj.utilcode.util.Utils

object BaseConfig {
    var debug=BuildConfig.DEBUG
    @JvmStatic
    var onClickTimeDebouncing=200L

    fun openDebug(debug:Boolean){
        this.debug=debug
    }

    //App启动后初始化
    fun initConfig(app:Application) {
        Utils.init(app)
    }
}