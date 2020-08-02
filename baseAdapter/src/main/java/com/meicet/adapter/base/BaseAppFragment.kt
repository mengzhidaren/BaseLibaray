package com.meicet.adapter.base


import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity

/**
 * 这里做为基类全局项目调用
 *  当FragmentTransaction使用add，replace来切换Fragment时，Fragment显示隐藏的生命周期就是onCreate，onDetach；
 * 当FragmentTransaction使用hide，show来切换Fragment时，Fragment显示隐藏不会触动Fragment的生命周期，不过也有其他方法可以监听，那就是onHiddenChanged方法；
 * 当使用ViewPager来切换Fragment时，Fragment显示隐藏不会触动Fragment的生命周期，也不会触动onHiddenChanged方法，这时候可以使用setUserVisibleHint方法来监听；
 */
abstract class BaseAppFragment(layout: Int) : Fragment(layout) {

    private val lifeHide = mutableListOf<(hidden: Boolean) -> Unit>()
    private val lifePage = mutableListOf<(isVisibleToUser: Boolean) -> Unit>()

    override fun onHiddenChanged(hidden: Boolean) {
        super.onHiddenChanged(hidden)
        lifeHide.forEach {
            it.invoke(hidden)
        }

    }

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        lifePage.forEach {
            it.invoke(isVisibleToUser)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        lifeHide.clear()
    }

    fun addCallBackHidden(call: (hidden: Boolean) -> Unit) {
        lifeHide.add(call)
    }

}