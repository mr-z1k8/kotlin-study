package com.example.study.chapter.two.oop

/**
 * Use of "data".
 * CellphoneKt.kt == Cellphone.java
 *
 * if remove "data" keyword ,run result is false
 * fun main(){
 *  val phone1 = Cellphones("sun", 1299.99)
 *  val phone2 = Cellphones("sun", 1299.99)
 *  println("phone1 equeals phone2 " + (phone1 == phone2))
 * }
 *
 */
data class CellphoneKt(val brand: String, val price: Double)
