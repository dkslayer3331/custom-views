package com.mhst.padc_customview_module.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.mhst.padc_customview_module.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnGoToMv.setOnClickListener {
            val intent = ModifiedViewActivity.newIntent(this)
            startActivity(intent)
        }

        btnGoToRv.setOnClickListener {
            startActivity(ReactionViewPodActivity.newIntent(this))
        }

    }


}