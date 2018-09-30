package com.iyao.sample.method

import android.text.Spannable
import android.widget.EditText
import com.iyao.sample.User

class MethodContext: Method {
    var method: Method? = null
    override fun init(editText: EditText) {
        method?.init(editText)
    }

    override fun newSpannable(user: User): Spannable {
        return method?.newSpannable(user) ?: throw NullPointerException("method: null")
    }

}