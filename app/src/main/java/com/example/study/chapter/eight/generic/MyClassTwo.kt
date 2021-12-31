package com.example.study.chapter.eight.generic

class MyClassTwo {

    /**
     * Define method only.
     * Default <T: Any?> , so can pass in null. if it cannot be null, <T: Any>
     */
    fun <T> method(param: T): T {
        return param
    }

    /**
     * Define generic upper bound(上界，只允许数字类型，如 Int,Float,Double等).
     */
    fun <T : Number> method(param: T): T {
        return param
    }

    /**
     * "HigherLevelFunctionKt.kt" StringBuilder.build use of generic
     *
     * Usage:
     * contentResolver.query(uri, null,null,null,null)?.build{
     *      while(moveToNext()){
     *          ...
     *      }
     *      close()
     * }
     */
    fun <T> T.build(block: T.() -> Unit): T {
        block()
        return this
    }
}