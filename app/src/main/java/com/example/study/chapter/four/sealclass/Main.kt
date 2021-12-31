package com.example.study.chapter.four.sealclass

import android.app.Application
import leakcanary.OnObjectRetainedListener
import java.lang.IllegalArgumentException

class Main {

    /**
     * No "else" will point out error
     */
    fun getResultKtMsg(result: IResult) = when (result) {
        is ISuccess -> result.msg
        is IFailure -> result.error.message
        else -> throw IllegalArgumentException()
    }

    /**
     * "else" is not required
     */
    fun getResultMsg(result: Result) = when (result) {
        is Success -> result.msg
        is Failure -> result.error.message
    }

}