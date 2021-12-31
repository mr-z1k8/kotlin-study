package com.example.study.chapter.five.extend

/**
 * Extension function(扩展函数s).
 */
class StringUtil {

    /**
     * Returns the number of letters(字母) in a string.
     */
    fun lettersCount(str: String): Int {
        var count = 0
        for (char in str) {
            if (char.isLetter()) {
                count++
            }
        }
        return count
    }

    /**
     * Extension function to string. "ClassName".methodName(param1: Int, params2: Int):Int
     * No strings param need to be passed in, use this.
     * Always create a extension function in the corresponding "ClassName".kt
     * Usage:
     *  val count = "ABC123xyz!@#".letters()
     */
    fun String.letters():Int{
        var count = 0
        // this = this@String
        for (char in this){
            if (char.isLetter()){
                count++
            }
        }
        return count
    }

}