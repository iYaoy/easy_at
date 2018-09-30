package com.iyao.eastat.span

import android.text.Spannable

interface DirtySpan {
    fun isDirty(text: Spannable): Boolean
}