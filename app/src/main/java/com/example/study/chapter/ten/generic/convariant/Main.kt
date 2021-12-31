package com.example.study.chapter.ten.generic.convariant

class Main {

    fun main(){
        val student = Student("Tom", 16)
        val data = SimpleData<Student>()
        data.set(student)
        // In fact, this line of code will report an error. Here, it is assumed that it can be compiled
//        handleSimpleData(data)
        val studentData = data.get() // there report an error, get() data need a student, but real is a teacher in handleSimpleData was setted.

    }

    private fun handleSimpleData(data: SimpleData<Person>) {
        val teacher = Teacher("Jack", 35)
        data.set(teacher)
    }

    /*************************************************************************************/


    fun main2(){
        val student = Student("Tom", 16)
        val data = SimpleData2<Student>(student)
        handleSimpleData2(data)
        val studentData = data.get()
    }

    private fun handleSimpleData2(data: SimpleData2<Person>) {
        val personData = data.get()
    }
}