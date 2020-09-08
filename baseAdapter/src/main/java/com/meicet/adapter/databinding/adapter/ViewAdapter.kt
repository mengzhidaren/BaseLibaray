package com.meicet.adapter.databinding.adapter

import android.view.View
import android.widget.SeekBar
import androidx.databinding.BindingAdapter
import com.meicet.adapter.utils.gone
import com.meicet.adapter.utils.onClickOnce
import com.meicet.adapter.utils.onClickOnceSingle
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

@BindingAdapter("visiable")
fun bindViewVisibility(view: View, visiable: Boolean) {
    view.visiable(visiable)
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

@BindingAdapter("onClickOnce")
fun bindOnClickOnce(view: View, onClickOnce: View.OnClickListener) {
    view.onClickOnce {
        onClickOnce.onClick(it)
    }
}

@BindingAdapter("onClickSingle")
fun bindOnClickSingle(view: View, onClickSingle: View.OnClickListener) {
    view.onClickOnceSingle {
        onClickSingle.onClick(it)
    }
}

@BindingAdapter("onSeekChange")
fun bindSeekBarChange(view: SeekBar, onSeekChange: (progress: Int) -> Unit) {
    view.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
        override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
            onSeekChange.invoke(progress)
        }

        override fun onStartTrackingTouch(seekBar: SeekBar?) {

        }

        override fun onStopTrackingTouch(seekBar: SeekBar?) {

        }
    })
}
