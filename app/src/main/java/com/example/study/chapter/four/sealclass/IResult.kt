package com.example.study.chapter.four.sealclass

import java.lang.Exception

/**
 * create a interface , and create two class extends it
 */
interface IResult

class ISuccess(val msg: String): IResult
class IFailure(val error: Exception): IResult