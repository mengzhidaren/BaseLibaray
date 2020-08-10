package com.meicet.adapter.databinding.adapter

import android.view.View
import androidx.databinding.BindingAdapter
import com.meicet.adapter.utils.gone
import com.meicet.adapter.utils.visiable


/**
 * author : meicet on 2020/4/1
 * desc:
 */


@BindingAdapter("gone")
fun bindGone(view: View, gone: Boolean) {
    view.gone(gone)
}


@BindingAdapter("visibility")
fun bindVisibility(view: View, visibility: Boolean) {
    view.visiable(visibility)
}


@BindingAdapter("isSelect")
fun bindSelect(view: View, isSelect: Boolean) {
    view.isSelected = isSelect
}

@BindingAdapter("onClickSelect")
fun bindOnClickSelect(view: View, isSelect: Boolean) {
    view.isSelected = isSelect
    view.setOnClickListener {
        it.isSelected = !it.isSelected
    }
}

