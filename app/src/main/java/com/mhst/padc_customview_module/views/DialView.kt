package com.mhst.padc_customview_module.views

/**
 * Created by Moe Htet on 19,July,2020
 */
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import androidx.core.content.withStyledAttributes
import com.mhst.padc_customview_module.R
import kotlin.math.cos
import kotlin.math.min
import kotlin.math.sin

private enum class FanSpeed(val label: Int) {
    OFF(R.string.fan_off),
    LOW(R.string.fan_low),
    MEDIUM(R.string.fan_medium),
    HIGH(R.string.fan_high);

    fun next() = when (this) {
        OFF -> LOW
        LOW -> MEDIUM
        MEDIUM -> HIGH
        HIGH -> OFF
    }
}

private const val RADIUS_OFFSET_LABEL = 30
private const val RADIUS_OFFSET_INDICATOR = -35

private var radius = 0.0f
private var fanSpeed = FanSpeed.OFF


private val pointPosition: PointF = PointF(0.0f, 0.0f)


private var fanSpeedLowColor = Color.YELLOW
private var fanSpeedMediumColor = Color.GREEN
private var fanSpeedMaxColor = Color.RED

class DialView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {

        style = Paint.Style.FILL
        textAlign = Paint.Align.CENTER
        textSize = 55.0f
        typeface = Typeface.create("", Typeface.BOLD)
    }

    init {
        isClickable = true

        context.withStyledAttributes(attrs, R.styleable.DialView) {
            fanSpeedLowColor = getColor(R.styleable.DialView_fanColor1, 0)
            fanSpeedMediumColor = getColor(R.styleable.DialView_fanColor2, 0)
            fanSpeedMaxColor = getColor(R.styleable.DialView_fanColor3, 0)
        }
    }


    override fun performClick(): Boolean {
        if (super.performClick()) return true

        fanSpeed = fanSpeed.next()

        invalidate()
        return true
    }


    override fun onSizeChanged(width: Int, height: Int, oldWidth: Int, oldHeight: Int) {
        radius = (min(width, height) / 2.0 * 0.8).toFloat()

    }


    private fun PointF.computeXYForSpeed(pos: FanSpeed, radius: Float) {
        pos.ordinal
        val startAngle = Math.PI * (9 / 8.0)
        val angle = startAngle + pos.ordinal * (Math.PI / 4)
        x = (radius * cos(angle)).toFloat() + width / 2
        y = (radius * sin(angle)).toFloat() + height / 2
    }


    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        drawBackground(canvas)

        drawIndicatorCircle(canvas)

        drawTextLabels(canvas)
    }

    private fun drawBackground(canvas: Canvas) {


        paint.color = when (fanSpeed) {
            FanSpeed.OFF -> Color.GRAY
            FanSpeed.LOW -> fanSpeedLowColor
            FanSpeed.MEDIUM -> fanSpeedMediumColor
            FanSpeed.HIGH -> fanSpeedMaxColor
        }


        canvas.drawCircle((width / 2).toFloat(), (height / 2).toFloat(), radius, paint)

    }

    private fun drawIndicatorCircle(canvas: Canvas) {

        val markerRadius = radius + RADIUS_OFFSET_INDICATOR


        pointPosition.computeXYForSpeed(fanSpeed, markerRadius)


        paint.color = Color.BLACK

        canvas.drawCircle(pointPosition.x, pointPosition.y, radius / 12, paint)
    }

    private fun drawTextLabels(canvas: Canvas) {


        val labelRadius = radius + RADIUS_OFFSET_LABEL

        for (i in FanSpeed.values()) {
            pointPosition.computeXYForSpeed(i, labelRadius)
            val label = resources.getString(i.label)
            canvas.drawText(label, pointPosition.x, pointPosition.y, paint)
        }
    }

}