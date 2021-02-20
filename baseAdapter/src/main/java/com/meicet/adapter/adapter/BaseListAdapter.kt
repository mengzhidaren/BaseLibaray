package com.meicet.adapter.adapter

import androidx.annotation.LayoutRes
import com.chad.library.adapter.base.module.LoadMoreModule

/**
 * 自动加载更多的adapter
 */
abstract class BaseListAdapter<T>(@LayoutRes layoutID: Int = 0, list: MutableList<T>? = null) :
    BaseRefreshAdapter<T>(layoutID, list), LoadMoreModule {


    val pageInfo = BasePageInfo()

    //是否启用loadMore
    private var loadMoreEnable = true

    //有headerView时但没有数据---是否显示空布局
    var headerBottomShowEmptyLayout = false


    var onCallRequestPage: (page: BasePageInfo) -> Unit = {}


    //请求网络加载下一页
    private fun loadMoreUI() {
        onCallRequestPage.invoke(pageInfo)
    }

    //重置当前页面
    fun onReSetPage() {
        pageInfo.reset()
    }

    //下拉刷新回调接口
    override fun onPullRefresh() {
        refreshUI()
    }

    fun closeLoadMore() {
        loadMoreEnable = false
    }

    fun openLoadMore() {
        loadMoreEnable = true
    }

    //重新从第一页开始请求
    open fun refreshUI(clear: Boolean = false) {
        if (clear) {//有数据时会清空显示出来loading
            setNewInstance(null)
        }
        statusView?.showLoading()
        if (loadMoreEnable) {
            loadMoreModule.isEnableLoadMore = false
        }
        pageInfo.reset()
        onCallRequestPage.invoke(pageInfo)
    }

    /**
     * 是否最后一页   true 没有更多数据，不在请求onCallRequestPage     false 还有下一页
     */
    open fun onLoadMoreEndPage(list: List<T>?) = list?.size ?: 0 < pageInfo.pageSize

    /**
     * 滑到底后 是否隐藏加载更多的view   true消失
     */
    open fun onLoadMoreGone() = getDefItemCount() < pageInfo.showPageSize


    //请求成功一页
    open fun loadPage(list: List<T>?) {
        if (loadMoreEnable) {
            loadMoreModule.isEnableLoadMore = true
        }
        if (pageInfo.isFirstPage()) {
            onRefreshFinish()
            if (list == null || list.isEmpty()) {
                isUseEmpty = !(hasHeaderLayout() && !headerBottomShowEmptyLayout)
                statusView?.showEmpty()
                setNewInstance(null)
            } else {
                setNewInstance(list.toMutableList())
            }
        } else {
            if(!list.isNullOrEmpty()){
                addData(list)
            }
        }
        if (loadMoreEnable) {
            if (onLoadMoreEndPage(list)) {
                //第一页数据可能小于showPageSiz 这时会不满一屏，就不显示加载完成
                loadMoreModule.loadMoreEnd(onLoadMoreGone())
            } else {
                //page加一
                pageInfo.nextPage()
                loadMoreModule.loadMoreComplete()
            }
        } else {
            loadMoreModule.loadMoreEnd(true)
        }
    }


    /**
     *     请求失败
     */
    open fun loadPageError(error: String) {
        if (pageInfo.isFirstPage()) {
            setNewInstance(null)
            onRefreshFinish()
            statusView?.showError(error)
        } else {
            if (loadMoreEnable) {
                loadMoreModule.isEnableLoadMore = true
                loadMoreModule.loadMoreFail()
            } else {
                loadMoreModule.loadMoreEnd(true)
            }
        }
    }

    init {
        loadMoreModule.setOnLoadMoreListener {
            loadMoreUI()
        }
        //当自动加载开启，同时数据不满一屏时，是否继续执行自动加载更多(默认为true)
        loadMoreModule.isEnableLoadMoreIfNotFullPage = false
        //空数据时是否显示 header
        headerWithEmptyEnable = true
    }
}


