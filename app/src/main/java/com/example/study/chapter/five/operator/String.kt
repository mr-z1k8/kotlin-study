package com.example.study.chapter.five.operator

import java.lang.StringBuilder

/**
 * Operator overloading and Extension function simultaneous use
 * "times": (a * b) = a.times(b)
 *
 * Usage:
 *  val str = "ABC" * 3
 *  println(str)
 *  // ABCABCABC
 */
operator fun String.times(n: Int): String {
    val builder = StringBuilder()
    repeat(n){
        builder.append(this)
    }
    return builder.toString()
}