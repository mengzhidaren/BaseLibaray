package com.meicet.adapter.dialog

import android.content.Context
import android.view.Gravity
import android.view.LayoutInflater
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.lxj.xpopup.core.CenterPopupView


abstract class DialogCenterBinding<T:ViewDataBinding>(context: Context) : CenterPopupView(context) {


    lateinit var binding:T
    //绑定布局
    abstract fun bindingLayout(): Int
    //初始化数据
    abstract fun create()

    override fun addInnerContent() {
        binding= DataBindingUtil.inflate(
                LayoutInflater.from(context),
                bindingLayout(),
                centerPopupContainer,
                false
        )
       val param=  binding.root.layoutParams as LayoutParams
        param.gravity=Gravity.CENTER
        centerPopupContainer.addView(binding.root,param)
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