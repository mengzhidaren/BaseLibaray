package com.meicet.adapter.databinding.adapter;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.LevelListDrawable;
import android.widget.TextView;

import androidx.databinding.BindingAdapter;

public class TextAdapter {

    @BindingAdapter("textLevel")
    public static void bindTextLevel(TextView textView, int level) {
        Drawable data = textView.getBackground();
        if (data instanceof LevelListDrawable) {
            data.setLevel(level);
        }
    }
}
