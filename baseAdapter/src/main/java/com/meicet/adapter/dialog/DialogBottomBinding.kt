package com.meicet.adapter.dialog

import android.content.Context
import android.view.LayoutInflater
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.lxj.xpopup.core.BottomPopupView

abstract class DialogBottomBinding<T: ViewDataBinding>(context: Context) :BottomPopupView(context) {
    lateinit var binding:T

    abstract fun bindingLayout():Int
    abstract fun create()

    override fun addInnerContent() {
        binding= DataBindingUtil.inflate(
                LayoutInflater.from(context),
                bindingLayout(),
                bottomPopupContainer,
                false
        )
        bottomPopupContainer.addView(binding.root)
    }

    override fun onCreate() {
        super.onCreate()
        create()
    }

    override fun dismiss() {
        super.dismiss()
        binding.unbind()
    }

}