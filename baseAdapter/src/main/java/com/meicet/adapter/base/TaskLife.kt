package com.meicet.adapter.base

class TaskLife(private val oneSingle: Boolean = false) {
    private val lifeList = HashMap<Int, DisposableLife>()

    fun onDestroy() {
        if (lifeList.isEmpty()) return
        synchronized(TaskLife::class.java) {
            lifeList.values.forEach {
                it.onDestroy()
            }
            lifeList.clear()
        }
    }

    fun removeTask(hash: Int) {
        lifeList.remove(hash)
//        _i("减 TaskLife $hash")
    }

    fun addTask(task: DisposableLife, hash: Int) {
        if (oneSingle) {
            onDestroy()
        }
        lifeList[hash] = task
//        _i("加 TaskLife $hash")
    }

}

