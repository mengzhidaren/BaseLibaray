package com.meicet.adapter.databinding.line

import android.content.Context
import android.graphics.Color

import com.yanyusong.y_divideritemdecoration.Y_Divider
import com.yanyusong.y_divideritemdecoration.Y_DividerBuilder
import com.yanyusong.y_divideritemdecoration.Y_DividerItemDecoration

class LineBottom(context: Context,val height:Float) : Y_DividerItemDecoration(context) {


    override fun getDivider(itemPosition: Int): Y_Divider {
        return Y_DividerBuilder()
            .setBottomSideLine(true, Color.TRANSPARENT, height, 0f, 0f)
            .create()
    }


}
// isHave  最后一后下面是否划线
class LineBottomColor(context: Context,val color:Int) : Y_DividerItemDecoration(context) {


    override fun getDivider(itemPosition: Int): Y_Divider {
        return Y_DividerBuilder()
            .setBottomSideLine(true, color, 0.6f, 0f, 0f)
            .create()
    }


}