package com.mhst.padc_customview_module.activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mhst.padc_customview_module.R
import com.mhst.padc_customview_module.viewpods.StateProgressViewPod
import kotlinx.android.synthetic.main.activity_modified_view.*

class ModifiedViewActivity : AppCompatActivity() {

    private lateinit var mViewPodStateProgress: StateProgressViewPod


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_modified_view)
        setUpViewPod()
        setListener()
    }

    companion object{
        fun newIntent(context: Context) : Intent{
            return Intent(context,ModifiedViewActivity::class.java)
        }
    }

    private fun setUpViewPod() {
        mViewPodStateProgress = vpProgress as StateProgressViewPod
        mViewPodStateProgress.apply {
            setStepDescription("Survey", "Cabling", "Splicing", "Activate")
        }
    }

    private fun setListener() {

        btn1.setOnClickListener {
            mViewPodStateProgress.onTapStep1()
        }

        btn2.setOnClickListener {
            mViewPodStateProgress.onTapStep2()
        }

        btn3.setOnClickListener {
            mViewPodStateProgress.onTapStep3()
        }

        btn4.setOnClickListener {
            mViewPodStateProgress.onTapStep4()
            mViewPodStateProgress.completeAllSteps()
        }

    }


}