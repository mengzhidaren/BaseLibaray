package com.meicet.adapter.utils

import android.os.Build
import android.os.Process
import android.util.Log
import com.blankj.utilcode.util.AppUtils
import com.blankj.utilcode.util.FileIOUtils
import com.blankj.utilcode.util.ThrowableUtils
import com.blankj.utilcode.util.TimeUtils

class AppException : Thread.UncaughtExceptionHandler {
    companion object {
        val instance = AppException()
    }

    fun init() {
        Thread.setDefaultUncaughtExceptionHandler(this)
    }

    override fun uncaughtException(thread: Thread?, ex: Throwable?) {
        println("程序挂掉了")
        if(ex==null){
            Process.killProcess(Process.myPid())
            System.exit(1)
            return
        }
        val sb = StringBuilder()
        val head = "************* Log Head ****************" +
                "[---------程序挂掉-----]:${TimeUtils.getNowString()} "
                "\nDevice Manufacturer: " + Build.MANUFACTURER +
                "\nDevice Model       : " + Build.MODEL +
                "\nAndroid Version    : " + Build.VERSION.RELEASE +
                "\nAndroid SDK        : " + Build.VERSION.SDK_INT +
                "\n************* Log end ****************\n\n"
        sb.append(head)
            .append(ThrowableUtils.getFullStackTrace(ex))
        val crashInfo = sb.toString()
        // 3.把错误的堆栈信息 获取出来
        writeToLogFile(crashInfo)
        Log.e("yyl", "crashInfo=$crashInfo")
        AppUtils.exitApp()
    }

//    /**
//     * 获取错误的信息
//     */
//    private fun getErrorInfo(arg1: Throwable): String {
//        val writer = StringWriter()
//        val pw = PrintWriter(writer)
//        arg1.printStackTrace(pw)
//        pw.close()
//        return writer.toString()
//    }
//    @Synchronized
    private fun writeToLogFile(msg: String) {
//        val logFile=FileRoot.getCrashLogFile()
//        FileIOUtils.writeFileFromString(
//            logFile,
//            msg,
//            true
//        )
    }

}