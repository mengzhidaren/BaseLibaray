package com.meicet.adapter.base

import android.os.Bundle
import android.view.View
/**
 * FragmentTransaction使用hide，show来切换Fragment时，延迟加载 show之后加载
 */
@Deprecated("用新版本吧")
abstract class BaseAppFragmentShowLazy(layout:Int):BaseAppFragment(layout) {

    private var isInit=false
    private var isLoaded = false

    override fun onHiddenChanged(hidden: Boolean) {
        super.onHiddenChanged(hidden)
        if(isInit&&!hidden){
            onLazyLoad()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        isInit=true
        if(!isHidden&&isVisible){
            onLazyLoad()
        }
    }

    override fun onDestroyView() {
        isInit=false
        isLoaded=false
        super.onDestroyView()
    }
    fun onLazyLoad() {
        if (!isLoaded) {
            isLoaded = true
            lazyLoad()
        }
    }
    abstract fun lazyLoad()
}