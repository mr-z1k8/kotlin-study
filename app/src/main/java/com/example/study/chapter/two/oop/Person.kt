package com.example.study.chapter.two.oop

/**
 * a class supports extends, "open" keyword need to be added
 */
open class Person(val name: String ,val age: Int) {

    init {
        println("name: $name")
        println("age: $age")
    }
}