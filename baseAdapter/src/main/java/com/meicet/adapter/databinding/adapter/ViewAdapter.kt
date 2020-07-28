package com.meicet.adapter.databinding.adapter

import android.view.View
import androidx.databinding.BindingAdapter
import com.meicet.adapter._gone
import com.meicet.adapter._visiable


/**
 * author : meicet on 2020/4/1
 * desc:
 */


@BindingAdapter("gone")
fun bindGone(view: View, gone: Boolean){
    view._gone(gone)
}


@BindingAdapter("visibility")
fun bindVisibility(view: View, visibility: Boolean){
    view._visiable(visibility)
}


@BindingAdapter("isSelect")
fun bindSelect(view: View, isSelect: Boolean) {
   view.isSelected=isSelect
}

