package com.example.study.chapter.four.sealclass

import java.lang.Exception

/**
 * like IResult.kt, this is 密封类. "interface" replace "sealed class", and extends Result need ()
 */
sealed class Result
class Success(val msg: String) : Result()
class Failure(val error: Exception) : Result()