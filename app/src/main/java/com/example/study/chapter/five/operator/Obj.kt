package com.example.study.chapter.five.operator

/**
 * Operator overloading(运算符重载).
 * Contains "+-*\"...
 */
class Obj(val value: Int) {

    /**
     * Operator overloading enables two objects to be added.
     * Usage:
     *  val obj1 = Obj(5)
     *  val obj2 = Obj(10)
     *  val obj3 = obj1 + obj2
     *  println(obj3.value)
     */
    operator fun plus(obj: Obj): Obj{
        val sum = value + obj.value
        return Obj(value)
    }

    /**
     * Multiple overload
     * Usage:
     *  val obj1 = Obj(5)
     *  val obj2 = Obj(10)
     *  val obj3 = obj1 + obj2
     *  val obj4 = obj3 + 20
     *  println(obj4.value)
     */
    operator fun plus(newValue: Int): Obj{
        val sum = value + newValue
        return Obj(sum)
    }
}