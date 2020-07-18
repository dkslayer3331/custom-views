package com.mhst.padc_customview_module.activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mhst.padc_customview_module.R

class ModifiedViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_modified_view)
    }

    companion object{
        fun newIntent(context: Context) : Intent{
            return Intent(context,ModifiedViewActivity::class.java)
        }
    }

}