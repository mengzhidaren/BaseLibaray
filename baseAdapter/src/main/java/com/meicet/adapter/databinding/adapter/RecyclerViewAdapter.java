package com.meicet.adapter.databinding.adapter;


import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.RecyclerView;


import com.chad.library.adapter.base.BaseQuickAdapter;
import com.meicet.adapter.databinding.line.LineBottom;
import com.meicet.adapter.databinding.line.LineBottomColor;


public final class RecyclerViewAdapter {



    @BindingAdapter("adapter")
    public static void setAdapter(RecyclerView recyclerView, BaseQuickAdapter adapter) {
        recyclerView.setAdapter(adapter);
    }

    @BindingAdapter("lineBottom")
    public static void setLineState(RecyclerView recyclerView, float sizeHeight) {
        recyclerView.addItemDecoration(new LineBottom(recyclerView.getContext(),sizeHeight));

    }

    @BindingAdapter("lineColor")
    public static void setLineState(RecyclerView recyclerView, int color) {
        recyclerView.addItemDecoration(new LineBottomColor(recyclerView.getContext(),color));

    }

}
