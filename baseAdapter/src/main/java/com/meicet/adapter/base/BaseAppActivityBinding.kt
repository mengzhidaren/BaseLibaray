package com.meicet.adapter.base

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseAppActivityBinding<T : ViewDataBinding> : BaseAppActivity() {

    lateinit var binding: T

    abstract fun bindingLayout(): Int

    open fun useBinding() = true
    private var useBind = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        useBind = useBinding()
        if (useBind) {
            binding = DataBindingUtil.setContentView(this, bindingLayout())
        }
    }

    override fun onDestroy() {
        if (useBind) {
            binding.unbind()
        }
        super.onDestroy()
    }
}