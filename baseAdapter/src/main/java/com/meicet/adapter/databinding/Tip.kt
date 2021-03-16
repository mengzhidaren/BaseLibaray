package com.meicet.adapter.databinding

/***
动态设置颜色
android:textColor="@{user.vip? 0xffff0000:0xff000000}"

java的字符串拼接 --不是单引号‘，而是一个数字键1左边那个键`
android:text="@{user.nickName + `(` + user.name +`)`}"
android:text="@{user.nickName + `@string/aa`}"
android:text="@{user.nickName ?? user.name}"   //空逻辑运算


设置View上属性默认值
android:text="@{user.firstName, default=test}"


双向绑定
双向绑定使用@={}就可以实现了  例如：EditText中双向绑定


LiveData连用
DataBinding需调用setLifecycleOwner(LifecycleOwner lifecycleOwner)之后，绑定了LiveData数据源的xml控件才会随着数据变化而改变
1.postValue：允许后台线程向主进程推送数据
2.setValue：只允许在主线程调用

@BindingAdapter(value = {"bind:imageBitmap"},requireAll = true)
public static void setImageBitmap(ImageView view,Bitmap bitmap){
view.setImageBitmap(bitmap);
}

 */


object Tip{

    fun onClickEvent(){

    }
}