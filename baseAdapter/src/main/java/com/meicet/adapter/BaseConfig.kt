package com.meicet.adapter

import android.app.Application
import com.blankj.utilcode.util.Utils

object BaseConfig {
    val debug=BuildConfig.DEBUG

    //App启动后初始化
    fun initConfig(app:Application) {
        Utils.init(app)
    }
}