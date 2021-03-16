package com.yyl.viewbinding.adapter

import android.graphics.drawable.LevelListDrawable
import android.widget.TextView
import androidx.databinding.BindingAdapter


@BindingAdapter("textLevel")
fun bindTextLevel(textView: TextView, level: Int) {
    val data = textView.background
    (data as? LevelListDrawable)?.level = level
}
