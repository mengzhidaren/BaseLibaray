package com.meicet.adapter.adapter


abstract class BaseMultiMode(val layout:Int) {
    val layoutType by lazy {layout}


    abstract fun bindData(holder: BaseHolder, position: Int)

    abstract fun getItemCount(): Int
    //点用空间的 权重大小   spanCount = 撑满    一半就是 spanCount/2
    open fun getGridSpanSize(spanCount: Int, position: Int): Int = spanCount
}