package com.yyl.viewbinding.adapter

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.meicet.adapter.databinding.line.LineBottom
import com.meicet.adapter.databinding.line.LineBottomColor


@BindingAdapter("adapter")
fun setAdapter(recyclerView: RecyclerView, adapter: BaseQuickAdapter<*, *>?) {
    recyclerView.adapter = adapter
}

@BindingAdapter("lineBottom")
fun setLineState(recyclerView: RecyclerView, sizeHeight: Float) {
    recyclerView.addItemDecoration(LineBottom(recyclerView.context, sizeHeight))
}

@BindingAdapter("lineColor")
fun setLineState(recyclerView: RecyclerView, color: Int) {
    recyclerView.addItemDecoration(LineBottomColor(recyclerView.context, color))
}
