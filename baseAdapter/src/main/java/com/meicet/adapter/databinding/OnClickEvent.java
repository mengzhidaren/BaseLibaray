package com.meicet.adapter.databinding;

import android.app.Activity;
import android.view.View;

public class OnClickEvent {

    public static void backClick(View view) {
        Activity context = (Activity) view.getContext();
        if (context != null) {
            context.finish();
        }
    }

}
