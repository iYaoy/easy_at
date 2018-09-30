package com.iyao.sample.method

import android.text.Spannable
import android.view.KeyEvent
import android.widget.EditText
import com.iyao.eastat.KeyCodeDeleteHelper
import com.iyao.eastat.NoCopySpanEditableFactory
import com.iyao.eastat.SpanFactory
import com.iyao.sample.User
import com.iyao.eastat.span.DataBindingSpan
import com.iyao.eastat.watcher.SelectionSpanWatcher

object Weibo: Method {
    override fun init(editText: EditText) {
        editText.text = null
        editText.setEditableFactory(NoCopySpanEditableFactory(
                SelectionSpanWatcher(
                        DataBindingSpan::class)))
        editText.setOnKeyListener { v, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_DEL && event.action == KeyEvent.ACTION_DOWN) {
                return@setOnKeyListener KeyCodeDeleteHelper.onDelDown(
                        (v as EditText).text)
            }
            return@setOnKeyListener false
        }
    }

    override fun newSpannable(user: User): Spannable {
        return SpanFactory.newSpannable(user.getSpannedName(), user)
    }

}