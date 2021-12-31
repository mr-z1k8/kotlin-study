package com.example.study.chapter.ten.service

import android.app.IntentService
import android.content.Intent

/**
 * IntentService.
 * a auto create thread execute work, than done work can be closed the service.
 * Principle: To be continued !
 */
class MyIntentService(name: String?) : IntentService(name) {

    override fun onHandleIntent(intent: Intent?) {
        // This is a worker thread
        // TODO("Not yet implemented")
    }
}