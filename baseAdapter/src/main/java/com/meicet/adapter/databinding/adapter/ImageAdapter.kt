package com.meicet.adapter.databinding.adapter

import android.net.Uri
import android.text.TextUtils
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import java.io.File


@BindingAdapter("level")
fun setImageLevel(imageView: ImageView, level: Int) {
    imageView.setImageLevel(level)
}

@BindingAdapter("imageFile")
fun setImageFile(imageView: ImageView, path: String?) {
    if (!TextUtils.isEmpty(path)) {
        val file = File(path!!)
        if (file.exists()) {
            imageView.setImageURI(Uri.fromFile(file))
        }
    }
}

@BindingAdapter("imageResource")
fun bindImageViewResource(imageView: ImageView, resource: Int) {
    imageView.setImageResource(resource)
}
