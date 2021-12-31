package com.example.study.chapter.six.higherorderfunction

import kotlin.text.StringBuilder

/**
 * Higher-Level function. One function is passed as a parameter into another function
 */
class HigherLevelFunctionKt {

    /**
     * Complete grammar(完整语法):
     * "ClassName".(String, Int) -> Unit
     */
    fun num1Andnum2(num1: Int, num2: Int, func: (Int, Int) -> Int): Int {
        val result = func(num1, num2)
        return result
    }

    fun num1Andnum2(
        num1: Int,
        num2: Int,
        block1: (Int, Int) -> Int,
        block2: (Int, Int) -> Int
    ): Int {
        var result1 = 0
        var result2 = 0
        result1 = block1(num1, num2)
        result2 = block2(num1, num2)
        return result1 + result2
    }

    fun plus(num1: Int, num2: Int): Int {
        return num1 + num2
    }

    fun minus(num1: Int, num2: Int): Int {
        return num1 - num2
    }

    fun main() {
        val num1 = 100
        val num2 = 80
        val num3 = num1Andnum2(num1, num2, ::plus)
        val num4 = num1Andnum2(num1, num2, ::minus)
        println("result1 is $num3")
        println("result2 is $num4")

        val num5 = num1Andnum2(num1, num2, ::plus, ::minus)
        println("result3 is $num5")
    }

    /**
     * Use of Higher-Level function and lambda
     * Principle: HigherLevelFunction.java
     * !!! tip: any lambda will eventually turn into an anonymous class(匿名类), resulting in additional memory and performance overhead. for example HigherLevelFunction.java
     *  so has "inline"
     */
    fun main2() {
        val num1 = 100
        val num2 = 80
        val num3 = num1Andnum2(num1, num2) { n1, n2 ->
            n1 + n2
        }
        val num4 = num1Andnum2(num1, num2) { n1, n2 ->
            n1 - n2
        }
        println("result1 is $num3")
        println("result2 is $num4")

        /**
         * The last Higher-Level function can be put outside:
         *
         * val num5 = num1Andnum2(num1, num2, { n1, n2 ->
         *      n1 + n2
         *  }) { n1, n2 ->
         *  n1 - n2
         * }
         */
        val num5 = num1Andnum2(num1, num2, { n1, n2 ->
            n1 + n2
        }, { n1, n2 ->
            n1 - n2
        })
        println("result3 is $num5")
    }


    /**
     *  "StringBuilder." means param of function defined in StringBuilder.class
     */
    fun StringBuilder.build(block: StringBuilder.() -> Unit): StringBuilder {
        block()
        return this
    }

    fun main3() {
        val list = listOf("apple", "banana", "orange", "pear", "grape")
        val result = StringBuilder().build {
            append("start eat fruits. \n")
            for (fruit in list) {
                append(fruit).append("\n")
            }
            append("ate all fruits.\n")
        }
        println(result.toString())
    }

}
