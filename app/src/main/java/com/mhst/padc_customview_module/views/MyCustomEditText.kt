package com.mhst.padc_customview_module.views

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Rect
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.content.withStyledAttributes
import com.mhst.padc_customview_module.R

/**
 * Created by Moe Htet on 17,July,2020
 */
class MyCustomEditText(context: Context?, attrs: AttributeSet?) :
    AppCompatEditText(context, attrs) {

    var mPrefix = "+959"
    var mColor = Color.BLACK

    private val mRect = Rect()

    init {
       context?.withStyledAttributes(attrs,
           R.styleable.PrefixCustomEditText
       ){
         mPrefix = getString(R.styleable.PrefixCustomEditText_prefix) ?: mPrefix
         mColor = getColor(R.styleable.PrefixCustomEditText_prefixColor,mColor)
       }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        paint.getTextBounds(mPrefix,0,mPrefix.length,mRect)
        mRect.right += paint.measureText(" ").toInt()
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    }

    override fun onDraw(canvas: Canvas?) {
        paint.color = mColor
        canvas?.drawText(mPrefix,
        super.getCompoundPaddingLeft().toFloat(),
        baseline.toFloat(),
        paint
        )
        super.onDraw(canvas)
    }


}