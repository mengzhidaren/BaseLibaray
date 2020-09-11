package com.meicet.adapter.databinding.adapter

import android.view.View
import androidx.databinding.BindingAdapter
import com.meicet.adapter.utils.gone
import com.meicet.adapter.utils.onClickOnce
import com.meicet.adapter.utils.onClickOnceSingle
import com.meicet.adapter.utils.visiable


/**
 * author : yyl on 2020/4/1
 * desc:
 */
object ViewAdapter {
    @JvmStatic
    @BindingAdapter("gone")
    fun bindGone(view: View, gone: Boolean) {
        view.gone(gone)
    }

    @JvmStatic
    @BindingAdapter("visibility")
    fun bindVisibility(view: View, visibility: Boolean) {
        view.visiable(visibility)
    }
    @JvmStatic
    @BindingAdapter("visiable")
    fun bindViewVisibility(view: View, visiable: Boolean) {
        view.visiable(visiable)
    }
    @JvmStatic
    @BindingAdapter("isSelect")
    fun bindSelect(view: View, isSelect: Boolean) {
        view.isSelected = isSelect
    }
    @JvmStatic
    @BindingAdapter("onClickSelect")
    fun bindOnClickSelect(view: View, isSelect: Boolean) {
        view.isSelected = isSelect
        view.setOnClickListener {
            it.isSelected = !it.isSelected
        }
    }
    @JvmStatic
    @BindingAdapter("onClickOnce")
    fun bindOnClickOnce(view: View, onClickOnce: View.OnClickListener) {
        view.onClickOnce {
            onClickOnce.onClick(it)
        }
    }
    @JvmStatic
    @BindingAdapter("onClickSingle")
    fun bindOnClickSingle(view: View, onClickSingle: View.OnClickListener) {
        view.onClickOnceSingle {
            onClickSingle.onClick(it)
        }
    }


}