package com.meicet.adapter.adapter


import android.util.SparseIntArray
import android.view.ViewGroup
import androidx.annotation.LayoutRes


abstract class BaseMultiListAdapter<T>(list: MutableList<T>? = null) : BaseListAdapter<T>(0, list) {

    private val layouts: SparseIntArray by lazy(LazyThreadSafetyMode.NONE) { SparseIntArray() }

    /**
     * 调用此方法，设置多布局
     * @param type Int
     * @param layoutResId Int
     */
    protected fun addItemType(type: Int, @LayoutRes layoutResId: Int) {
        layouts.put(type, layoutResId)
    }

    override fun getDefItemViewType(position: Int): Int {
        return getItemTypeDef(position)
    }

    abstract fun getItemTypeDef(position: Int): Int

    override fun onCreateDefViewHolder(parent: ViewGroup, viewType: Int): BaseHolder {
        val layoutResId = layouts.get(viewType)
        require(layoutResId != 0) { "ViewType: $viewType found layoutResId，please use addItemType() first!" }
        return createBaseViewHolder(parent, layoutResId)
    }


}