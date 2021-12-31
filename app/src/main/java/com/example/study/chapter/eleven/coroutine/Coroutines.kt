package com.example.study.chapter.eleven.coroutine

import kotlinx.coroutines.*

/**
 * 可以在任何地方调用
 * GlobalScope.launch.
 * runBlocking.
 *
 * 可以在协程作用域或挂起函数中调用
 * coroutineScope.
 *
 * 只能在协程作用域中调用
 * launch.
 */
class Coroutines {


    /**
     * GlobalScope.launch. a top-level coroutines
     */
    fun global() {

        GlobalScope.launch {
            println("codes run in coroutine scope")
        }
        // When the application runs, it will end together, so Thread.sleep(1000) Blocking for 1 second.
        Thread.sleep(1000)
    }

    fun global2() {
        GlobalScope.launch {
            println("codes run in coroutine scope")
            delay(1500)
            // you can find this print message can't output
            println("codes run in coroutines scope finished")
        }
        Thread.sleep(1000)
    }


    /**
     * runBlocking.
     *
     * One can ensure that the current thread is blocked until all code and sub processes within the scope of the collaboration are executed
     */
    fun run() {
        runBlocking {
            println("codes run in coroutine scope")
            delay(1500)
            println("codes run in coroutines scope finished")
        }
    }

    fun run2() {
        // How to create multiple coroutines?  use of launch.
        /**
         * launch.
         * 1. Launch creates a sub coroutines.
         * 2. Launch can be called only when it is within the scope of the coroutine(协程的作用域).
         * 3. child cooperation process is that if the cooperation process of the outer scope ends, all child cooperation processes under the scope will also end.
         */
        runBlocking {
            launch {
                println("launch1")
                delay(1000)
                println("launch1 finished")
            }
            launch {
                println("launch2")
                delay(1000)
                println("launch2 finished")
            }
        }
    }

    fun run3() {
        /**
         * coroutine No operating system is required in the scheduling process, Concurrency efficiency(并发效率) will be high.
         */
        val start = System.currentTimeMillis()
        runBlocking {
            // create 100000 sub coroutines, running time very short. but if thread, oom has been generated.
            repeat(100000) {
                launch {
                    println(".")
                }
            }
        }
        val end = System.currentTimeMillis()
        println(end - start)
    }

    /**
     * suspend. Suspend function(挂起函数)
     */
    fun main() {
        runBlocking {
            launch {
                // 如何提取部分代码到一个单独的函数中，并且也能够使用delay()这样的挂起函数。suspend。
                sus()
            }
        }
    }

    suspend fun sus() {
        /**
         * delay. suspend current function, it is within the scope of the coroutine.
         *
         * runBlocking {
         *     ...
         *     delay(1000)
         *     ...
         *     launch {
         *          ...
         *          delay(1000)
         *          ...
         *     }
         * }
         */
        println(".")
        delay(1000)
    }


    /**
     * coroutineScope. also a suspend function.
     *
     * 可以在任何的挂起函数或协程作用域中调用，它的特点是会"继承外部的协程的作用域"(本身并不会创建作用域)并创建一个子协程。
     * 能够让你在单独的函数中调用launch.
     */
    fun main2(){
        runBlocking {
            printDot()
        }
    }
    suspend fun printDot() = coroutineScope {
        launch {
            println(".")
            delay(1000)
        }
    }


    /**
     * async.
     */


    /**
     * withContext()
     */

    /**
     * suspendCoroutines
     */

}