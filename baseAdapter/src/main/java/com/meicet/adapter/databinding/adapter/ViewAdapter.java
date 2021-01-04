package com.meicet.adapter.databinding.adapter;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.LevelListDrawable;
import android.view.View;

import androidx.databinding.BindingAdapter;

import com.meicet.adapter.utils.ViewExtensionKt;

public class ViewAdapter {

    @BindingAdapter("gone")
    public static void bindGone(View view, boolean gone) {
        ViewExtensionKt.gone(view, gone);
    }

    @BindingAdapter("visiable")
    public static void bindViewVisibility(View view, boolean visiable) {
        ViewExtensionKt.visiable(view, visiable);
    }

    @BindingAdapter("levelBG")
    public static void bindLevelBG(View view, int level) {
        Drawable data = view.getBackground();
        if (data instanceof LevelListDrawable) {
            data.setLevel(level);
        }
    }

    @BindingAdapter("isSelect")
    public static void bindSelect(View view, boolean isSelect) {
        view.setSelected(isSelect);
    }

    @BindingAdapter("onClickSelect")
    public static void bindOnClickSelect(View view, boolean isSelect) {
        view.setSelected(isSelect);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setSelected(!v.isSelected());
            }
        });
    }

    @BindingAdapter("onClickOnce")
    public static void bindOnClickOnce(View view, View.OnClickListener onClickListener) {
        ViewExtensionKt.onClickOnce(view, onClickListener);
    }

    @BindingAdapter("onClickSingle")
    public static void bindOnClickSingle(View view, View.OnClickListener onClickListener) {
        ViewExtensionKt.onClickOnceSingle(view, onClickListener);
    }
}
