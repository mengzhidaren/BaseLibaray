package com.meicet.adapter.adapter

import android.view.View
import androidx.annotation.LayoutRes
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder

abstract class BaseAdapter<T>(@LayoutRes layoutID: Int = 0, list: MutableList<T>? = null) :
    BaseQuickAdapter<T, BaseHolder>(layoutID, list)

open class BaseHolder(view: View) : BaseViewHolder(view)
