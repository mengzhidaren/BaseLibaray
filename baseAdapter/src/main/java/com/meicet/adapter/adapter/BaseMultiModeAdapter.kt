package com.meicet.adapter.adapter


import android.graphics.Canvas
import android.graphics.Rect
import android.util.Log
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView


/**
 * //多类型适配  继承BaseMultiMode
 * 第一步  配置网络请求
 *   adapter.onCallRequestPage={
 *   Api.getData(
 *   { adapter.loadPage(data)}
 *   {adapter.loadPageError()}
 *   )
 *   ......
 *   }
 *   第二步
 *   adapter.refreshUI()
 */
open class BaseMultiModeAdapter(
    list: MutableList<BaseMultiMode>? = null,
    private val useDecoration: Boolean = false
) :
    BaseListAdapter<BaseMultiMode>(0, list) {
    private val tag = "BaseMultiModeAdapter"

    private val decoration = object : RecyclerView.ItemDecoration() {
        //onDraw：在item绘制之前时被调用，将指定的内容绘制到item view内容之下；
        override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {

        }
        //onDrawOver：在item被绘制之后调用，将指定的内容绘制到item view内容之上
        override fun onDrawOver(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {

        }
        override fun getItemOffsets(
            outRect: Rect,
            view: View,
            parent: RecyclerView,
            state: RecyclerView.State
        ) {
            val position = parent.getChildAdapterPosition(view) - headerLayoutCount
            if (position > -1 && data.isNotEmpty()) {
                convertItemOffsets(outRect, position)
            }
        }
    }

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        setGridSpanSizeLookup { gridLayoutManager, _, position ->
            var spanCount = gridLayoutManager.spanCount
            run breaking@{
                var currentIndex = 0
                data.forEachIndexed findValue@{ index, baseMultiMode ->
                    val count = baseMultiMode.getItemCount()
                    val max = currentIndex + count
                    if (position < max) {
                        val pos = count - (max - position)
                        spanCount = data[index].getGridSpanSize(spanCount, pos)
                        return@breaking
                    } else {
                        currentIndex = max
                    }
                }
            }
            spanCount
        }
        super.onAttachedToRecyclerView(recyclerView)
        if (useDecoration)
            recyclerView.addItemDecoration(decoration)
    }

    override fun onDetachedFromRecyclerView(recyclerView: RecyclerView) {
        super.onDetachedFromRecyclerView(recyclerView)
        if (useDecoration)
            recyclerView.removeItemDecoration(decoration)
    }


    override fun addData(newData: Collection<BaseMultiMode>) {
        super.addData(newData)
    }

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
        ___ii(tag, "getDefItemViewType 不可能的错误 position=$position")
        return 0
    }


    override fun onCreateDefViewHolder(parent: ViewGroup, viewType: Int): BaseHolder {
        return createBaseViewHolder(parent, viewType)
    }

    //这里在 onCreateDefViewHolder 之后调用 用于databing  这里只在创建时调用一次
    // 感觉没啥用  因为DataBindingUtil.bind<?>(view) 里面会根据tag找到缓存对像
//    override fun onItemViewHolderCreated(viewHolder: BaseHolder, viewType: Int) {
//        run bindingview@{
//            data.forEach {
//                if (it.layoutType == viewType) {
//                    it.onDataBindingViewHolderCreate(viewHolder)
//                    return@bindingview
//                }
//            }
//        }
//
//    }

    override fun onBindViewHolder(holder: BaseHolder, position: Int) {
        super.onBindViewHolder(holder, position)
        when (holder.itemViewType) {
            LOAD_MORE_VIEW, HEADER_VIEW, EMPTY_VIEW, FOOTER_VIEW -> {
            }
            else -> {
                convertData(holder, position - headerLayoutCount)
            }
        }
    }

    private fun convertData(holder: BaseHolder, position: Int) {
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
        ___ii(tag, "convertData  不可能的错误  position=$position")
    }

    fun convertItemOffsets(outRect: Rect, adapterPosition: Int) {
        var currentIndex = 0
        data.forEachIndexed { index, baseMultiMode ->
            val childCount = baseMultiMode.getItemCount()
            val max = currentIndex + childCount
            if (adapterPosition < max) {
                val childPos = childCount - (max - adapterPosition)
                data[index].getItemOffsets(outRect, childPos)
                return
            } else {
                currentIndex = max
            }
        }
        ___ii(tag, "findChildPositionByAdapterPosition  不可能的错误   adapterPosition=$adapterPosition")
    }


    //当前adapter的position  在data中的下标
    fun findIndexByPosition(position: Int): Int {
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
        ___ii(tag, "findPositionIndex  不可能的错误   position=$position")
        return 0
    }

    //当前adapter的type  在data中的下标
    fun findIndexByType(type: String): Int {
        data.forEachIndexed { index, baseMultiMode ->
            if (type == baseMultiMode.type) {
                return index
            }
        }
        ___ii(tag, "findIndexByType  没有这个type  type=$type")
        return 0
    }

    //当前adapter的type  在position中的下标
    fun findPositionFirstByType(type: String): Int {
        var currentIndex = 0
        data.forEachIndexed { _, baseMultiMode ->
            if (type == baseMultiMode.type) {
                return currentIndex
            }
            val count = baseMultiMode.getItemCount()
            currentIndex += count
        }
        ___ii(tag, "findIndexByType  没有这个type  type=$type")
        return 0
    }


    //当前位置上面 第一个可见的type
    fun findUpFirstTypeByPosition(position: Int): String {
        var currentIndex = 0
        var firstType = BaseMultiMode.TYPE_NO
        data.forEachIndexed { _, baseMultiMode ->
            val count = baseMultiMode.getItemCount()
            val haveType = baseMultiMode.type != BaseMultiMode.TYPE_NO
            if (haveType) {
                firstType = baseMultiMode.type
            }
            val max = currentIndex + count
            if (position < max) {
                return firstType
            } else {
                currentIndex = max
            }
        }
        ___ii(tag, "findUpFirstTypePositionByPosition  没有发现type  position=$position")
        return BaseMultiMode.TYPE_NO
    }

    //在data中的下标 在adapter 中第一个显示位置position    indexMode从下标 0 开始
    fun findIndexFirstPosition(dataIndex: Int): Int {
        var currentIndex = 0
        data.forEachIndexed { index, baseMultiMode ->
            if (index == dataIndex) {
                return currentIndex
            } else {
                currentIndex += baseMultiMode.getItemCount()
            }
        }
        ___ii(tag, "findIndexFirstPosition  不可能的错误   indexMode=$dataIndex")
        return 0
    }

    //弃用
    @Deprecated("这里空实现  子类不要调用")
    override fun convert(holder: BaseHolder, item: BaseMultiMode) {

    }

    private fun ___ii(tag: String, msg: String) {
        Log.e(tag, msg)
    }
}