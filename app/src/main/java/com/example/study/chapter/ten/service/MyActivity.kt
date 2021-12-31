package com.example.study.chapter.ten.service

import android.app.Activity
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.view.View
import android.widget.Button

class MyActivity : Activity(), View.OnClickListener {

    private lateinit var btn_start: Button
    private lateinit var btn_bind: Button
    private lateinit var btn_unbind: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onClick(view: View) = when (view.id) {
        btn_start.id -> {
            val intent = Intent(this, MyService::class.java)
            startService(intent)
            // onCreate -> onStartCommand -> onDestroy()
            // tip: Multiple startService only execute onece onCreate, execute onStartCommand multiple times. but there is a service instance.
            Unit
        }
        btn_bind.id -> {
            val intent = Intent(this, MyService::class.java)
            bindService(intent, serviceConnect, Context.BIND_AUTO_CREATE)
            // onCreate -> onBind -> onDestroy()
            Unit
        }
        btn_unbind.id -> {
            unbindService(serviceConnect)
        }
        else -> Unit
    }

    val serviceConnect = object : ServiceConnection {
        override fun onServiceConnected(p0: ComponentName?, p1: IBinder?) {
            // TODO("Not yet implemented")
        }

        override fun onServiceDisconnected(p0: ComponentName?) {
            // TODO("Not yet implemented")
        }

    }


}