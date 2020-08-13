package com.meicet.adapter.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

abstract class BaseAppActivity : AppCompatActivity() {
    //网络请求生命周期管理
    val taskLife = TaskLife()
    val taskLifeOnce = TaskLife(true)
    protected lateinit var context:BaseAppActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        context=this
    }

    override fun onDestroy() {
        taskLife.onDestroy()
        taskLifeOnce.onDestroy()
        super.onDestroy()
    }
}