package com.meicet.adapter.base

import android.os.Bundle
import android.view.View

/**
 * viewPage 延迟加载
 */
@Suppress("DEPRECATION")
@Deprecated("用新版本吧")
abstract class BaseAppFragmentPageLazy(layout: Int) : BaseAppFragment(layout) {
    private var isLoaded = false
    private var isInit = false


    /**
     *使用ViewPager来切换Fragment时，Fragment显示隐藏不会触动Fragment的生命周期，也不会触动onHiddenChanged方法，
     * 这时候可以使用setUserVisibleHint方法来监听；
     */
    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        if (isVisibleToUser && isInit) {
            onLazyLoad()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        isInit=true
        if (userVisibleHint) { //自动滑动太快getUserVisibleHint()会为false
            onLazyLoad()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        isInit=false
        isLoaded=false
    }

    /**
     * 第一屏时加载
     */
    private fun onLazyLoad() {
        if (!isLoaded) {
            isLoaded = true
            lazyLoad()
        }
    }

    abstract fun lazyLoad()
}