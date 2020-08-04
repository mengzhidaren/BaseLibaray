package com.meicet.adapter.adapter


//多类型适配  继承BaseMultiMode
//这个适合监听 视频播放器 的生命周期
open class BaseMultiModeAttachAdapter(list: MutableList<BaseMultiMode>? = null) :
        BaseMultiModeAdapter(list) {
    private val tag = "BaseMultiModeAdapter"

    override fun onViewAttachedToWindow(holder: BaseHolder) {
        super.onViewAttachedToWindow(holder)
        val position = holder.adapterPosition - headerLayoutCount
        if (position >= 0 && data.isNotEmpty()) {
            val index = findIndexByPosition(position)
            data[index].onViewAttachedToWindow(holder, position)
        }
    }

    override fun onViewDetachedFromWindow(holder: BaseHolder) {
        super.onViewDetachedFromWindow(holder)
        val position = holder.adapterPosition - headerLayoutCount
        if (position >= 0 && data.isNotEmpty()) {
            val index = findIndexByPosition(position)
            data[index].onViewDetachedFromWindow(holder, position)
        }
    }


}