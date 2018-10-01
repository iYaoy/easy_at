package com.iyao.sample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.SpannableStringBuilder
import android.text.method.ScrollingMovementMethod
import com.iyao.sample.method.*
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    private val methods = arrayOf(QQ, WeChat, Weibo)
    private var iterator: Iterator<Method> = methods.iterator()
    private val methodContext = MethodContext()
    private val users = arrayListOf(
            User("1", "激浊扬清"),
            User("2", "清风引佩下瑶台"),
            User("3", "浊泾清渭"),
            User("4", "刀光掩映孔雀屏"),
            User("5", "清风徐来"),
            User("6", "英雄无双风流婿"),
            User("7", "源清流洁"),
            User("8", "占断人间天上福"),
            User("9", "清音幽韵"),
            User("10", "碧箫声里双鸣凤"),
            User("11", "风清弊绝"),
            User("12", "天教艳质为眷属"),
            User("13", "独清独醒"),
            User("14", "千金一刻庆良宵"),
            User("15", "必须要\\n\n，不然不够长"))
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnAppend.setOnClickListener {
            if (methodContext.method == null) {
                switch()
            }
            val user = users[Random().nextInt(15)].copy()
            (normalEdit.text as SpannableStringBuilder)
                    .append(methodContext.newSpannable(user))
                    .append(" ")
        }
        btnSwitch.setOnClickListener {
            switch()
        }
        btnPrint.setOnClickListener { _ ->
            val editable = normalEdit.text
            txtLogs.text = editable.getSpans(0, normalEdit.length(), User::class.java).joinToString("\n") {
                "$it, ${editable.getSpanStart(it)}, ${editable.getSpanEnd(it)}"
            }
            txtLogs.scrollTo(0, 0)
        }
        txtLogs.movementMethod = ScrollingMovementMethod.getInstance()
    }

    private fun switch() {
        val method = circularMethod()
        methodContext.method = method
        btnSwitch.text = method.javaClass.simpleName
        methodContext.init(normalEdit)
    }

    private tailrec fun circularMethod(): Method {
        return if (iterator.hasNext()) {
            iterator.next()
        } else {
            iterator = methods.iterator()
            circularMethod()
        }
    }
}
