package com.meicet.adapter.databinding.adapter

import android.net.Uri
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import java.io.File


@BindingAdapter("level")
fun setlevel(imageView: ImageView, level: Int) {
    imageView.setImageLevel(level)
}


@BindingAdapter("imageFile")
fun setImageFile(imageView: ImageView, path: String?) {
    if (path != null) {
        val file = File(path)
        if (file.exists()) {
            imageView.setImageURI(Uri.fromFile(file))
        }
    }

}
