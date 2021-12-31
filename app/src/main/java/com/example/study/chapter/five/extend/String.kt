package com.example.study.chapter.five.extend

/**
 * The extension function is preferably the top-level method, can be called by global
 */
fun String.lettersCount(): Int{
    var count = 0
    // this = this@String
    for (char in this){
        if (char.isLetter()){
            count++
        }
    }
    return count
}