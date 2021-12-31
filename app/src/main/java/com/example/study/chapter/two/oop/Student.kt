package com.example.study.chapter.two.oop

/**
 * a class default not extends.
 */
class Student(val sno: String, val grade: Int, name: String, age: Int) : Person(name, age), Study {
    /**
     * class is primary constructor
     * inner constructor is Secondary constructors
     */
    constructor(name: String, age: Int) : this("", 0, name, age) {
    }
    constructor(): this("", 0){
    }

    /**
     * constructor
     * Java Uages:
     *     public Student(String sno, int grade){
     *          println("sno:" + sno);
     *          println("grade:" + grade);
     *     }
     */
    init {
        println("sno: $sno")
        println("grade: $grade")
    }

    override fun readBooks() {
        // TODO("Not yet implemented")
    }

    override fun doHomework() {
        // TODO("Not yet implemented")
    }

}