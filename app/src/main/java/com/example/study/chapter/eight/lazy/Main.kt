package com.example.study.chapter.eight.lazy

import android.content.UriMatcher

class Main {
    private val bookDir = 0
    private val bookItem = 1
    private val categoryDir = 2
    private val categoryItem = 3
    private val authority = "com.example.study.chapter.eight.provider"

    /**
     * Rules:
     * val p by lazy{...}
     * "by" is keyword; lazy is Higher-level function, lazy can create a p object,
     *      when call p attribute is same as call getValue(),
     *      than getValue() function call lazy function pass in lambda,
     *      and called p attribute get back value was returned in last line.
     *
     *  Implement a "lazy function" of your own in "Later.kt"
     */
    val uriMatcher by later {
        val matcher = UriMatcher(UriMatcher.NO_MATCH)
        matcher.addURI(authority, "book", bookDir)
        matcher.addURI(authority, "book/#", bookItem)
        matcher.addURI(authority, "category", categoryDir)
        matcher.addURI(authority, "category/#", categoryItem)
        matcher
    }

    val matcher by lazy {
       //  ...
    }
}