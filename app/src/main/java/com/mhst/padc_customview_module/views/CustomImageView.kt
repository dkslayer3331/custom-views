package com.mhst.padc_customview_module.views

import android.content.Context
import android.graphics.Canvas
import android.graphics.Path
import android.graphics.RectF
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.content.withStyledAttributes
import com.mhst.padc_customview_module.R

/**
 * Created by Moe Htet on 18,July,2020
 */
class CustomImageView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : AppCompatImageView(context, attrs, defStyleAttr) {

    var cornerRadius = 0f

    private var path = Path()

    init {
        context.withStyledAttributes(attrs,
            R.styleable.CustomImage
        ){
            cornerRadius = getDimension(R.styleable.CustomImage_cornerRadius,0f)
        }
    }


    override fun onDraw(canvas: Canvas?) {
        val rectangle = RectF(0f,0f,width.toFloat(),height.toFloat())
        path.addRoundRect(rectangle,cornerRadius,cornerRadius,Path.Direction.CCW)
        canvas?.clipPath(path)
        super.onDraw(canvas)
    }


}