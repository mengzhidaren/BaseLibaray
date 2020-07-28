package com.meicet.adapter


abstract class BaseMultiMode {
    val layoutType by lazy { getLayout() }

    abstract fun getLayout(): Int

    abstract fun bindData(holder: BaseHolder, position: Int)

    abstract fun getItemCount(): Int

}