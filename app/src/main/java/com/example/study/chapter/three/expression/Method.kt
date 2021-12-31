package com.example.study.chapter.three.expression

/**
 * dynamic method and static method
 */
class Method {

    /**
     * use it , you need create a method object, than doAction().
     */
    fun doAction(){
        println("do action")
        doSomething()
    }

    /**
     * this is a static function. can use by method.doAction2().
     * tip: doAction2() is not really static method in the middle of the companion object
     */
    companion object{
        /**
         * only be called in kotlin
         */
        fun doAction2(){
            println("do action2")
        }

        /**
         * a real static method can add @JvmStatic annotation. you can be called it(doAction3()) in java and kotlin
         */
        @JvmStatic
        fun doAction3(){
            println("do action3")
        }
    }

}