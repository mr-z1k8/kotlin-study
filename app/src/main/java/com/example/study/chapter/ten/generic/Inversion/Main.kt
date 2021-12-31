package com.example.study.chapter.ten.generic.Inversion

import com.example.study.chapter.ten.generic.convariant.Person
import com.example.study.chapter.ten.generic.convariant.Student
import com.example.study.chapter.ten.generic.convariant.Teacher

class Main {

    fun main() {
        val trans = object : Transformer<Person> {
            override fun onTransform(t: Person): String {
                return "${t.name} ${t.age}"
            }
        }
        // report an error, Transformer(Person) can't cast to Transformer<Student>
//        handleTransformer(trans)
    }

    private fun handleTransformer(trans: Transformer<Student>) {
        val student = Student("Tom", 19)
        val result = trans.onTransform(student)
    }


    /***************************************************************************************/

    fun main2(){
        val trans = object : Transformer2<Person> {
            override fun onTransform(t: Person): String {
                return "${t.name} ${t.age}"
            }
        }
        handleTransformer2(trans)
    }

    private fun handleTransformer2(trans: Transformer2<Student>) {
        val student = Student("Tom", 19)
        val result = trans.onTransform(student)
    }


    /****************************************************************************************/

    /**
     * transformer是一个定义的接口类，本身Transformer<Student> 接收 Transformer<Person> 是没有问题的，Student作为Person的子类，能够访问相同的属性，
     * 但是此时允许 泛型T 在Transformer的out位时，就可能会出现返回的Teacher对象，对于传入的Student对象显然是不对的。故此，需要逆变限制 T 的返回。
     */
    fun main3(){
        val trans = object : Transformer3<Person> {
            override fun onTransform(name: String, age: Int ): Person {
                // running logcat print message  java.lang.ClassCastException: Teacher cannot be cast to Student
                return Teacher(name, age)
            }
        }
        handleTransformer3(trans)
    }

    private fun handleTransformer3(trans: Transformer3<Student>) {
        val result = trans.onTransform("Tom", 19)
    }
}