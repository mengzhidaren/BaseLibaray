package com.meicet.adapter.adapter


abstract class BaseMultiMode(val layout: Int) {
    val layoutType by lazy { layout }


    abstract fun bindData(holder: BaseHolder, position: Int)

    abstract fun getItemCount(): Int

    //gridLayoutManager才会调用   占用空间的权重大小   spanCount = 撑满    一半就是 spanCount/2
    open fun getGridSpanSize(spanCount: Int, position: Int): Int = spanCount



    //需要继承 BaseMultiModeAttachAdapter
    open fun onViewAttachedToWindow(holder: BaseHolder, position: Int) {}
    open fun onViewDetachedFromWindow(holder: BaseHolder, position: Int) {}

    //这里只有dataBinding时才可能会用到
    // 感觉没啥用  因为DataBindingUtil.bind<?>(view) 里面会根据tag找到缓存对像
//    open fun onDataBindingViewHolderCreate(holder: BaseHolder) {}
}