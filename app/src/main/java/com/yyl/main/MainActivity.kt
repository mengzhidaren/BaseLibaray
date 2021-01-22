package com.yyl.main

import android.database.DatabaseUtils
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.meicet.adapter.adapter.BaseHolder
import com.meicet.adapter.adapter.BaseListAdapter
import com.meicet.adapter.adapter.BaseTAdapter
import com.meicet.adapter.base.BaseAppActivity
import com.meicet.adapter.base.BaseAppActivityBinding
import com.yyl.main.databinding.ActivityMainBinding

class MainActivity : BaseAppActivityBinding<ActivityMainBinding>() {
    override fun bindingLayout()=R.layout.activity_main

//    val adapter=object :BaseListAdapter<String>(R.layout.item_text){
//        override fun convert(holder: BaseHolder, item: String) {
//            holder.setText(R.id.title1,"$item=${holder.adapterPosition}")
//        }
//    }
    val adapter=object :BaseTAdapter<String>(R.layout.item_text){
        override fun convert(holder: BaseHolder, item: String) {
            holder.setText(R.id.title1,"$item=${holder.adapterPosition}")
        }
        init {
            onCallRequestPage={
                loadPage(arrayListOf("ccccccc","ddddddddd","ssssssssssss"))
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        addHeard()
    binding.activity=this
    }


    fun chanageEmpty(){
        adapter.loadPage(null)
    }

    fun showHeard(){
        adapter.headerBottomShowEmptyLayout= !adapter.headerBottomShowEmptyLayout
    }
    fun addHeard(){
        val textv= TextView(context).apply {
            text="dsafdsafasdf"
        }
        adapter.addHeaderView(textv)
//        adapter.notifyDataSetChanged()
    }

    fun showList(){
        adapter.loadPage(arrayListOf("aaaaaaa","bbbbbbbbbb"))
    }

}