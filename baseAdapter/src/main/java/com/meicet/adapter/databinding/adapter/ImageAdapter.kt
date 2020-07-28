package com.meicet.adapter.databinding.adapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter



@BindingAdapter("level")
fun setlevel(imageView: ImageView, level: Int) {
    imageView.setImageLevel(level)
}
