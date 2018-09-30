package com.iyao.eastat.watcher

import android.text.SpanWatcher
import android.text.Spannable

open class SpanWatcherAdapter: SpanWatcher {
    override fun onSpanChanged(text: Spannable, what: Any, ostart: Int, oend: Int, nstart: Int,
                               nend: Int) {}

    override fun onSpanRemoved(text: Spannable, what: Any, start: Int, end: Int) {
    }

    override fun onSpanAdded(text: Spannable, what: Any, start: Int, end: Int) {
    }
}