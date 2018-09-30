package com.iyao.sample

import android.graphics.Color
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import com.iyao.eastat.span.DataBindingSpan
import com.iyao.eastat.span.DirtySpan

data class User(val id: String, var name: String): DataBindingSpan,
                                                   DirtySpan {

    fun getSpannedName(): Spannable {
        return SpannableString("@$name").apply {
            setSpan(ForegroundColorSpan(Color.CYAN), 0, length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        }
    }

    override fun isDirty(text: Spannable): Boolean {
        val spanStart = text.getSpanStart(this)
        val spanEnd = text.getSpanEnd(this)
        return spanStart >= 0 && spanEnd >= 0 && text.substring(spanStart, spanEnd) != name
    }
}