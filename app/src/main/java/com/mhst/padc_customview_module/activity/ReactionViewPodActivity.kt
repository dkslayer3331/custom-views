package com.mhst.padc_customview_module.activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.list.rados.fast_list.bind
import com.mhst.padc_customview_module.R
import com.mhst.padc_customview_module.viewpods.ReactionView
import kotlinx.android.synthetic.main.activity_reaction_view_pod.*
import kotlinx.android.synthetic.main.viewholder_item.view.*

class ReactionViewPodActivity : AppCompatActivity() {

    private val dummyList = listOf("1","2","4","5","6","7")

    lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reaction_view_pod)
        setupRecycler()
    }

    companion object{
        fun newIntent(context: Context) : Intent{
            return Intent(context,ReactionViewPodActivity::class.java)
        }
    }

    private fun setupRecycler(){
        recyclerView = rvItems
        recyclerView.bind(dummyList,R.layout.viewholder_item){item : String, pos : Int ->
            val vpReaction = vpReaction as ReactionView
            vpReaction.bindData(item)
        }.layoutManager(LinearLayoutManager(this).apply {
            orientation = LinearLayoutManager.VERTICAL
        })
    }

}