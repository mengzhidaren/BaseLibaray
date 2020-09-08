package com.meicet.adapter.adapter


import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import com.meicet.adapter.base.TaskLife
import com.meicet.adapter.view.Refreshable
import com.meicet.adapter.view.StatusListener
import com.meicet.adapter.view.StatusView


/**
 * 下拉刷新的adapter  通过父类获取对像配置
 */
abstract class BaseRefreshAdapter<T>(@LayoutRes layoutID: Int = 0, list: MutableList<T>? = null) :
    BaseQuickAdapter2<T, BaseHolder>(layoutID, list) {
    //网络请求生命周期管理
    val taskLife = TaskLife()
    val taskLifeOnce = TaskLife(true)

    var statusView: StatusListener? = null

    private var refreshable: Refreshable? = null
    private var useStateView = true
    fun closeStateView() {
        useStateView = false
    }

    //请求刷新回调接口
    abstract fun onPullRefresh()

    //完成下拉刷新请求  或者 错误重试
    protected fun onRefreshFinish() {
        refreshable?.finishRefresh()
    }

    //重制空状态
    open fun onStateViewAttach() {
        if (useStateView) {
            setEmptyStatus(StatusView(context))
        }
    }


    fun setEmptyStatus(view: StatusListener) {
        useStateView = true
        setEmptyView(view.getEmptyView())
        statusView = view
        view.setCallBackStatus(object : StatusListener.OnCallBackStatus {
            override fun onClickError(statusEmpty: Boolean) {
                onPullRefresh()
            }
        })
    }


    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        onStateViewAttach()
        val refresh = recyclerView.parent ?: return
        if (refresh is Refreshable) {
            refreshable = refresh
            refreshable?.setOnRefresh(object : Refreshable.CallBack {
                override fun onRefresh() {
                    onPullRefresh()
                }
            })
        }
    }


    override fun onDetachedFromRecyclerView(recyclerView: RecyclerView) {
        taskLife.onDestroy()
        taskLifeOnce.onDestroy()
        refreshable?.setOnRefresh(null)
        super.onDetachedFromRecyclerView(recyclerView)
    }

}
