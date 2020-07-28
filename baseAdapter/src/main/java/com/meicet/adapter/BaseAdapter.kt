package com.meicet.adapter

import android.view.View
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.entity.MultiItemEntity
import com.chad.library.adapter.base.viewholder.BaseViewHolder


//abstract class BaseAdapterBase<T, K : BaseHolder>(@LayoutRes layoutID: Int = 0, list: MutableList<T>? = null) :
//    BaseQuickAdapter<T, K>(layoutID, list)

abstract class BaseAdapter<T>(@LayoutRes layoutID: Int = 0, list: MutableList<T>? = null) :
    BaseQuickAdapter<T, BaseHolder>(layoutID, list)


open class BaseHolder(view: View) : BaseViewHolder(view)


//普通adapter 参考构建方法
//private class DemoAdapter : BaseAdapter<String>(R.layout.item_default) {
//    override fun convert(helper: BaseHolder, item: String) {
//        helper.getBinding<ViewDataBinding>()
//    }
//}
