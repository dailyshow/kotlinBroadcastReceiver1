package com.cis.kotlinbroadcastreceiver

import android.content.Intent
import android.content.IntentFilter
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var brapp: TestReciever? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addReceiver()

        btn.setOnClickListener { view ->
            var intent = Intent(this, TestReciever::class.java)
            sendBroadcast(intent)
        }
    }

    // 오레오 버전 이상에서 사용할 암시적 인텐트를 위해 broadcast receiver 등록
    fun addReceiver() {
        if(Build.VERSION.SDK_INT < Build.VERSION_CODES.O) {
            return
        }

        brapp = TestReciever()
        val filter = IntentFilter("com.cis.brapp1")
        registerReceiver(brapp, filter)
    }

    // app 이 종료되면 broadcast receiver 를 해제해준다.
    override fun onDestroy() {
        super.onDestroy()
        if (brapp != null) {
            unregisterReceiver(brapp)
            brapp = null
        }
    }
}
