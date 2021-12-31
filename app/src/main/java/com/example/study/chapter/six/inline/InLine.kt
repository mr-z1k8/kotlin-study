package com.example.study.chapter.six.inline

/**
 * inline function
 * reduce running overhead(减少运行开销) eg: Higher-level function、匿名类、 lambda ...
 *
 * "inline","noinline","crossinline"
 */
class InLine {

    /**
     * Automatically replace inline code to the place called during compilation, reduce running overhead.
     */
    inline fun num1Andnum2(num1: Int, num2: Int, func: (Int, Int) -> Int): Int {
        val result = func(num1, num2)
        return result
    }

    fun main() {
        val num1 = 100
        val num2 = 80
        val result = num1Andnum2(num1, num2) { n1, n2 ->
            n1 + n2
        }
        println("result is $result")
    }

    /**
     * noinline
     * when more than one higher-level function, someone can not be allowed to be inline.
     * because inline as a parameter , only pass in inline function, noinline can pass in any function.
     *
     */
    inline fun num1Andnum2(
        num1: Int,
        num2: Int,
        block1: (Int, Int) -> Int,
        noinline block2: (Int, Int) -> Int
    ): Int {
        val result1 = block1(num1, num2)
        val result2 = block2(num1, num2)
        return result1 + result2
    }

    fun main2() {
        val num1 = 100
        val num2 = 80
        val result = num1Andnum2(num1, num2, { n1, n2 -> n1 + n2 }) { n1, n2 ->
            n1 - n2
        }
    }

    /**
     * non-inline function return is exit lambda expression.
     */
    fun printString(str: String, block: (String) -> Unit) {
        println("printString begin")
        block(str)
        println("printString end")
    }

    fun main3() {
        print("main start")
        val str = ""
        printString(str) { s ->
            println("lambda start")
            if (s.isEmpty()) return@printString
            println(s)
            println("lambda end")
        }
        println("main end")
    }

    /**
     * inline function return is exit whole printString2 function
     */
    inline fun printString2(str: String, block: (String) -> Unit) {
        println("printString begin")
        block(str)
        println("printString end")
    }

    fun main4() {
        print("main start")
        val str = ""
        printString2(str) { s ->
            println("lambda start")
            if (s.isEmpty()) return
            println(s)
            println("lambda end")
        }
        println("main end")
    }

    /**
     * Normally any Higher-level function can use inline , but there are exceptions.
     *
     * use inline block() is error
     * when has implementation of other lambda or anonymous class, and call function type parameters, than declaration inline, must be error.
     * because inline functions if use "return" is exit whole function, however it is impossible to return outer call funcation.
     */
    fun runRunnable(block: () -> Unit) {
        val runnable = Runnable{
            block()
        }
        runnable.run()
    }

    /**
     * crossinline
     * promise inline functions will not use "return" keyword.
     */
    inline fun runRuunable2(crossinline block: () -> Unit){
        val runnable = Runnable{
            block()
        }
        runnable.run()
    }

}