package com.example.study.chapter.three.expression

/**
 * Use of "with" and "apply"、"let"
 */
class Study {

    /**
     * java Usage:
     *  if (stu != null){
     *      stu.readBook();
     *  }
     *  if (stu != null){
     *      stu.doHomework();
     *  }
     */
    fun useLet(stu: Student?){
        stu?.let {
            it.readBook()
            it.doHomework()
        }
    }

    inner class Student{

        fun readBook(){
            //
        }

        fun doHomework(){
            //
        }
    }


    /**
     * Usage:
     *  val builder = StringBuilder()
     *  builder.append("start eat fruit. \n")
     *  for (fruit in list) {
     *      builder.append(fruit).appen("\n")
     *  }
     *  builder.append("ate all fruits.")
     *  println(builder.toString())
     */
    fun useWith(){
        val list = listOf("apple", "banana", "orange", "pear", "grape")
        val result = with(StringBuilder()){
            append("start eat fruits.\n")
            for (fruit in list){
                append(fruit).append("\n")
            }
            append("ate all fruits.")
            // last line is a "return" method, hidden "return" keyword.
            toString()
        }
        println(result)
    }


    fun useApply(){
        val list = listOf("apple", "banana", "orange", "pear", "grape")
        val result = StringBuilder().apply {
            append("start eat fruits.\n")
            for (fruit in list){
                append(fruit).append("\n")
            }
            append("ate all fruits.")
        }
        // "apply" can't specify return value, only return self. so result is here a StringBuilder object.
        println(result.toString())
    }

}