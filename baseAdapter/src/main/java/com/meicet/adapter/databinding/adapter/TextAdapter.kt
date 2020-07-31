package com.meicet.adapter.databinding.adapter

import android.graphics.drawable.LevelListDrawable
import android.widget.TextView
import androidx.databinding.BindingAdapter


@BindingAdapter("textLevel")
fun bindTextLevel(textView: TextView, level: Int) {
    (textView.background as? LevelListDrawable)?.level = level
}

