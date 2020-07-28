package com.meicet.adapter


import android.util.Log
import android.view.ViewGroup


//多类型适配  继承BaseMultiMode
open class BaseMultiModeAdapter(list: MutableList<BaseMultiMode>? = null) :
    BaseListAdapter<BaseMultiMode>(0, list) {
    val tag = "BaseMultiModeAdapter"


    override fun getDefItemCount(): Int {
        var length = 0
        data.forEach {
            length += it.getItemCount()
        }
        return length
    }

    override fun getItem(position: Int): BaseMultiMode {
        return data[0]
    }

    override fun getDefItemViewType(position: Int): Int {
        var currentIndex = 0
        data.forEachIndexed { index, baseMultiMode ->
            val max = currentIndex + baseMultiMode.getItemCount()
            if (position < max) {
                return data[index].layoutType
            } else {
                currentIndex = max
            }
        }
        _i(tag, "getDefItemViewType 不可能的错误 position=$position")
        return 0
    }


    override fun onCreateDefViewHolder(parent: ViewGroup, viewType: Int): BaseHolder {
        return createBaseViewHolder(parent, viewType)
    }

    override fun onBindViewHolder(holder: BaseHolder, position: Int) {
        super.onBindViewHolder(holder, position)
        when (holder.itemViewType) {
            LOAD_MORE_VIEW, HEADER_VIEW, EMPTY_VIEW, FOOTER_VIEW -> null
            else -> {
                convertData(holder, position - headerLayoutCount)
            }
        }
    }

    fun convertData(holder: BaseHolder, position: Int) {
        var currentIndex = 0
        data.forEachIndexed { index, baseMultiMode ->
            val count = baseMultiMode.getItemCount()
            val max = currentIndex + count
            if (position < max) {
                val pos = count - (max - position)
                data[index].bindData(holder, pos)
                return
            } else {
                currentIndex = max
            }
        }
        _i(tag, "convertData  不可能的错误  position=$position")
    }

    fun findPositionIndex(position: Int): Int {
        var currentIndex = 0
        data.forEachIndexed { index, baseMultiMode ->
            val count = baseMultiMode.getItemCount()
            val max = currentIndex + count
            if (position < max) {
                return index
            } else {
                currentIndex = max
            }
        }
        _i(tag, "findPositionIndex  不可能的错误   position=$position")
        return 0
    }

    override fun convert(holder: BaseHolder, item: BaseMultiMode) {

    }

    private fun _i(tag: String, msg: String) {
        Log.e(tag, msg)
    }
}