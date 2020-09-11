package com.meicet.adapter.adapter

import androidx.annotation.LayoutRes
import com.chad.library.adapter.base.BaseQuickAdapter

abstract class BaseAdapter<T>(@LayoutRes layoutID: Int = 0, list: MutableList<T>? = null) :
    BaseQuickAdapter<T, BaseHolder>(layoutID, list)


