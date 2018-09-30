package com.iyao.sample.method

import android.text.Spannable
import android.widget.EditText
import com.iyao.sample.User

interface Method {

    fun init(editText: EditText)
    fun newSpannable(user: User): Spannable
}