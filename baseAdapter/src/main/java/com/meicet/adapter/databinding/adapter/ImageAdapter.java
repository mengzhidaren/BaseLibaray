package com.meicet.adapter.databinding.adapter;

import android.net.Uri;
import android.text.TextUtils;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import java.io.File;

public class ImageAdapter {

    @BindingAdapter("level")
    public static void setlevel(ImageView imageView, int level) {
        imageView.setImageLevel(level);
    }

    @BindingAdapter("imageFile")
    public static void setImageFile(ImageView imageView, String path) {
        if (!TextUtils.isEmpty(path)) {
            File file = new File(path);
            if (file.exists()) {
                imageView.setImageURI(Uri.fromFile(file));
            }
        }

    }
}
