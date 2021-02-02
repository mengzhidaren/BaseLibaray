package com.meicet.adapter.adapter

import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import com.chad.library.adapter.base.BaseQuickAdapter

abstract class BaseAdapter<T>(@LayoutRes layoutID: Int = 0, list: MutableList<T>? = null) :
    BaseQuickAdapter<T, BaseHolder>(layoutID, list)


abstract class BaseAdapterAttach<T>(@LayoutRes layoutID: Int = 0, list: MutableList<T>? = null) :
    BaseAdapter<T>(layoutID, list){
    var isAttached=false
    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        isAttached=true
    }

    override fun onDetachedFromRecyclerView(recyclerView: RecyclerView) {
        isAttached=false
        super.onDetachedFromRecyclerView(recyclerView)
    }
}