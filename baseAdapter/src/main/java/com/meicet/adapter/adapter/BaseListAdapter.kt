package com.meicet.adapter.adapter

import androidx.annotation.LayoutRes
import com.chad.library.adapter.base.module.LoadMoreModule

/**
 * 自动加载更多的adapter
 */
abstract class BaseListAdapter<T>(@LayoutRes layoutID: Int = 0, list: MutableList<T>? = null) :
    BaseRefreshAdapter<T>(layoutID, list),LoadMoreModule {


    private val pageInfo = BasePageInfo()
    //是否启用loadMore
    private var loadMoreEnable=true
    init {
//        setOnLoadMoreListener({})
        loadMoreModule.setOnLoadMoreListener {
            loadMoreUI()
        }
        //当自动加载开启，同时数据不满一屏时，是否继续执行自动加载更多(默认为true)
        loadMoreModule.isEnableLoadMoreIfNotFullPage = false
    }

    var onCallRequestPage: (page: BasePageInfo) -> Unit = {}


    //请求网络加载下一页
    private fun loadMoreUI() {
        onCallRequestPage.invoke(pageInfo)
    }

    //重置当前页面
    fun onReSetPage(){
        pageInfo.reset()
    }

    //下拉刷新回调接口
    override fun onPullRefresh() {
        refreshUI()
    }


    fun closeLoadMore(){
        loadMoreEnable=false
    }

    //重新从第一页开始请求
    fun refreshUI() {
        statusView?.showLoading()
        if(loadMoreEnable){
            loadMoreModule.isEnableLoadMore = false
        }
        pageInfo.reset()
        onCallRequestPage.invoke(pageInfo)
    }
    //请求成功一页
    fun loadPage(list: List<T>?) {
        if(loadMoreEnable){
            loadMoreModule.isEnableLoadMore = true
        }
        if (list == null) {
//            _i("BaseListAdapter", "返回了空数据")
            if(pageInfo.isFirstPage){
                statusView?.showEmpty()
            }else{
                if(loadMoreEnable){
                    loadMoreModule.loadMoreEnd()
                }

            }
            return
        }
        if (pageInfo.isFirstPage) {
            onRefreshFinish()
            if(list.isEmpty()){
//                statusView?.showStateEmpty()
                statusView?.showEmpty()
            }
            //如果是加载的第一页数据，用 setData()
//            replaceData(list)
            setNewInstance(list.toMutableList())
        } else {
            if (list.isNotEmpty()) {
                addData(list)
            }
        }
        if(loadMoreEnable){
            if (list.size <pageInfo.PAGE_SIZE) {
                    //第一页数据可能小于PAGE_SIZE   这时会不满一屏，就不显示加载完成
                loadMoreModule.loadMoreEnd(data.size<pageInfo.PAGE_SIZE)
//                loadMoreModule.loadMoreEnd()
            } else {
                loadMoreModule.loadMoreComplete()
            }
        }else{
            loadMoreModule.loadMoreEnd(true)
        }
        //        page加一
        pageInfo.nextPage()
    }
    //请求失败
    fun loadPageError(error:String) {
        if(pageInfo.isFirstPage){
            setNewInstance(null)
            onRefreshFinish()
            statusView?.showError(error)
        }else{
            if(loadMoreEnable){
                loadMoreModule.isEnableLoadMore = true
                loadMoreModule.loadMoreFail()
            }else{
                loadMoreModule.loadMoreEnd(true)
            }
        }
    }

}


open class BasePageInfo {

    val PAGE_SIZE = 10

    var page = 1

    fun nextPage() {
        page++
    }

    fun reset() {
        page = 1
    }

    val isFirstPage: Boolean
        get() = page == 1
}