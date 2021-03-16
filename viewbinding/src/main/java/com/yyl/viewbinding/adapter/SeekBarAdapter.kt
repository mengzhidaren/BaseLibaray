package com.yyl.viewbinding.adapter

import android.widget.SeekBar
import androidx.databinding.BindingAdapter


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
