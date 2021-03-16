package com.yyl.viewbinding.adapter

import android.graphics.drawable.LevelListDrawable
import android.view.View
import androidx.databinding.BindingAdapter
import com.meicet.adapter.utils.gone
import com.meicet.adapter.utils.onClickOnce
import com.meicet.adapter.utils.onClickOnceSingle
import com.meicet.adapter.utils.visiable


@BindingAdapter("gone")
fun bindGone(view: View, gone: Boolean) {
    view.gone(gone)
}

@BindingAdapter("visiable")
fun bindViewVisibility(view: View, visiable: Boolean) {
    view.visiable(visiable)
}

@BindingAdapter("levelBG")
fun bindLevelBG(view: View, level: Int) {
    val data = view.background
    (data as? LevelListDrawable)?.level = level
}

@BindingAdapter("isSelect")
fun bindSelect(view: View, isSelect: Boolean) {
    view.isSelected = isSelect
}

@BindingAdapter("onClickSelect")
fun bindOnClickSelect(view: View, isSelect: Boolean) {
    view.isSelected = isSelect
    view.setOnClickListener { v -> v.isSelected = !v.isSelected }
}

@BindingAdapter("onClickOnce")
fun bindOnClickOnce(view: View, onClickListener: View.OnClickListener?) {
    onClickListener?.let {
        view.onClickOnce(it)
    }

}

@BindingAdapter("onClickSingle")
fun bindOnClickSingle(view: View, onClickListener: View.OnClickListener?) {
    onClickListener?.let {
        view.onClickOnceSingle(it)
    }
}
