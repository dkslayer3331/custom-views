package com.mhst.padc_customview_module.activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mhst.padc_customview_module.R
import com.mhst.padc_customview_module.views.FaceView
import kotlinx.android.synthetic.main.activity_emotional_face.*

class EmotionalFaceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_emotional_face)

        happyButton.setOnClickListener {
            emotionalFaceView.happinessState = FaceView.HAPPY
        }

        sadButton.setOnClickListener {
            emotionalFaceView.happinessState = FaceView.SAD
        }

    }

    companion object{
        fun newIntent(context: Context) : Intent{
            return Intent(context,EmotionalFaceActivity::class.java)
        }
    }
}