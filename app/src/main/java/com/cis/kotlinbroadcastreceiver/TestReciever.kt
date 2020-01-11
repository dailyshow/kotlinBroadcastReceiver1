package com.cis.kotlinbroadcastreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class TestReciever : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        // intent 로 보내온 값을 broadcast receiver 로 출력할 수도 있다.
        val data1 = intent.getIntExtra("data1", 0)
        val data2 = intent.getDoubleExtra("data2", 0.0)
        val str = "data1 : ${data1}, data2 : ${data2}"

        if (data1.equals(0)) {
            // intent data1 이 기본값인 0일 경우 임의로 적어준 문자열 출력해서 보여줌
             val toast = Toast.makeText(context, "broadcast receiver 앱1 실행됨", Toast.LENGTH_SHORT)
            toast.show()
        } else {
            // 넘겨 받은 intent 값을 이용해서 출력해줌
            val toast = Toast.makeText(context, str, Toast.LENGTH_SHORT)
            toast.show()
        }

    }
}
