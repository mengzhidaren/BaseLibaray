package com.meicet.adapter.adapter

import androidx.annotation.IntRange
import androidx.annotation.LayoutRes
import androidx.annotation.NonNull
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder

/**
 * 注意  这个Adapter 的 setFooterView addFooterView  removeAllFooterView removeFooterView
 *  footView不会刷新
 *
 *  这个类主要修改 data.size的访问统一修改为 getDefItemCount()
 */
abstract class BaseQuickAdapter2<T, VH : BaseViewHolder>
@JvmOverloads constructor(
    @LayoutRes private val layoutResId: Int,
    data: MutableList<T>? = null
) : BaseQuickAdapter<T, VH>(layoutResId, data) {

    override fun getItemViewType(position: Int): Int {
        if (hasEmptyView()) {
            val header = headerWithEmptyEnable && hasHeaderLayout()
            return when (position) {
                0 -> if (header) {
                    HEADER_VIEW
                } else {
                    EMPTY_VIEW
                }
                1 -> if (header) {
                    EMPTY_VIEW
                } else {
                    FOOTER_VIEW
                }
                2 -> FOOTER_VIEW
                else -> EMPTY_VIEW
            }
        }

        val hasHeader = hasHeaderLayout()
        if (hasHeader && position == 0) {
            return HEADER_VIEW
        } else {
            var adjPosition = if (hasHeader) {
                position - 1
            } else {
                position
            }
            val dataSize = getDefItemCount()
            return if (adjPosition < dataSize) {
                getDefItemViewType(adjPosition)
            } else {
                adjPosition -= dataSize
                val numFooters = if (hasFooterLayout()) {
                    1
                } else {
                    0
                }
                if (adjPosition < numFooters) {
                    FOOTER_VIEW
                } else {
                    LOAD_MORE_VIEW
                }
            }
        }
    }




    /**
     * change data
     * 改变某一位置数据
     */
    override fun setData(@IntRange(from = 0) index: Int, data: T) {
        if (index >= this.getDefItemCount()) {
            return
        }
        this.data[index] = data
        notifyItemChanged(index + headerLayoutCount)
    }

    /**
     * add one new data
     * 添加一条新数据
     */
    override fun addData(@NonNull data: T) {
        this.data.add(data)
        notifyItemInserted(this.getDefItemCount() + headerLayoutCount)
        compatibilityDataSizeChanged2(1)
    }

    override fun addData(@NonNull newData: Collection<T>) {
        this.data.addAll(newData)
        notifyItemRangeInserted(this.getDefItemCount() - newData.size + headerLayoutCount, newData.size)
        compatibilityDataSizeChanged2(newData.size)
    }

    /**
     * remove the item associated with the specified position of adapter
     * 删除指定位置的数据
     *
     * @param position
     */
    override fun removeAt(@IntRange(from = 0) position: Int) {
        if (position >= getDefItemCount()) {
            return
        }
        this.data.removeAt(position)
        val internalPosition = position + headerLayoutCount
        notifyItemRemoved(internalPosition)
        compatibilityDataSizeChanged2(0)
        notifyItemRangeChanged(internalPosition, this.getDefItemCount() - internalPosition)
    }

    /**
     * compatible getLoadMoreViewCount and getEmptyViewCount may change
     *
     * @param size Need compatible data size
     */
    private fun compatibilityDataSizeChanged2(size: Int) {
        if (this.getDefItemCount() == size) {
            notifyDataSetChanged()
        }
    }




}