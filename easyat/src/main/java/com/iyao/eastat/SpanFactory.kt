package com.iyao.eastat

import android.text.Spannable
import android.text.SpannableString

object SpanFactory {
    fun newSpannable(source: CharSequence, vararg spans: Any): Spannable {
        return SpannableString.valueOf(source).apply {
            spans.forEach {
                setSpan(it, 0, length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
            }
        }
    }
}