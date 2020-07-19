package com.mhst.padc_customview_module.viewpods

import android.content.Context
import android.util.AttributeSet
import android.widget.RelativeLayout
import kotlinx.android.synthetic.main.viewpod_reaction.view.*

/**
 * Created by Moe Htet on 18,July,2020
 */
class ReactionViewPod @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : RelativeLayout(context, attrs, defStyleAttr) {

    private var mDelegate: Delegate? = null

    override fun onFinishInflate() {
        super.onFinishInflate()
        setUpListener()
    }

    fun setDelegate(delegate: Delegate) {
        mDelegate = delegate
    }

    fun bindData(data: String) {
        tvLikedUser.text = data
        tvCommentedUser.text = data
    }

    private fun setUpListener() {
        tvLike.setOnClickListener {
            mDelegate?.onTapLike()
        }

        tvComment.setOnClickListener {
            mDelegate?.onTapComment()
        }

        tvShare.setOnClickListener {
            mDelegate?.onTapShare()
        }
    }

    interface Delegate {

        fun onTapLike()
        fun onTapComment()
        fun onTapShare()
    }

}