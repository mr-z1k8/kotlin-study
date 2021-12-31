package com.example.study.chapter.eight.generic

fun main(){
    val myClass = MyClassOne<Int>()
    val result = myClass.method(123)
}

fun main2(){
    val myclass = MyClassTwo()
    // can write myClass.method(123) , Kotlin has excellent type derivation
    val result = myclass.method<Int>(123)
}