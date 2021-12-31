package com.example.study.chapter.two

import kotlin.math.max

/**
 * Use of "simplify function"、"when"、"for"
 */
class GrammarSugar {

    /**
     *  It can simplify function, when the function has only one line of code.
     *
     *  Usage1:
     *  fun largeNumber(num1: Int, num2: Int): Int{
     *      return max(num1,num2)
     *  }
     *
     *  Usage2:
     *  fun largeNumber(num1: Int, num2: Int): Int = max(num1, num2)
     */
    fun largeNumber1(num1: Int, num2: Int) = max(num1, num2)

    fun largeNumber2(num1: Int, num2: Int): Int {
        return if (num1 > num2) {
            num1
        } else {
            num2
        }
    }

    fun largeNumber3(num1: Int, num2: Int) = if (num1 > num2) num1 else num2

    /**
     * Usage:
     * fun getSocre(name: String): Int {
     *     var value = 0
     *     when (name) {
     *      "Tom" -> value = 86
     *      "Jim" -> value = 77
     *      "Jack" -> value = 95
     *      "Lily" -> value = 100
     *      else -> value = 0
     *     }
     *     return value
     * }
     */
    fun getSocre(name: String) = when(name){
        "Tom" -> 86
        "Jim" -> 77
        "Jack" -> 95
        "Lily" -> 100
        else -> 0
    }

    /**
     * kotlin "is" like "instanceof" in java.
     */
    fun checkNumer(num: Number){
        when(num){
            is Int -> println("number is int")
            is Double -> println("number is double")
            else -> println("number not support")
        }
    }

    /**
     * "when" not has params use.
     *  1. Both "Tom" and "Tommy" return 86
     *  2. "when" not has params that the judgment expression needs to be completely written in the "when" structure
     */
    fun getScore(name: String) = when {
        name.startsWith("Tom") -> 86
        name == "Jim" -> 77
        name == "Jack" -> 95
        name == "Lily" -> 100
        else -> 0
    }

    /**
     * use of "for"
     */
    fun getCount(){
        // 1..10  1 until 10 contain 1 and 10
        for (i in 1..10){
            println(i)
        }

        // 1 until 10 contain 1 but not 10
        for (i in 1 until 10){
            println(i)
        }

        // step 2 = 2 per lift
        for (i in 1..10 step 2){
            // 2,4,6,8,10
            println(i)
        }
    }

}