package com.example.study.chapter.eight.lazy

import kotlin.reflect.KProperty

fun <T> later(block: () -> T) = Later(block)

/**
 * lazy loading.
 */
class Later<T>(val block: () -> T) {

    var value: Any? = null

    /**
     * need "operator" modification(修饰).
     * any:Any? expression in what class will delegate functions be used.
     * prop:KProperty<*> property operation class, which indicates that you can obtain values related to various properties.
     */
    operator fun getValue(any: Any?, prop: KProperty<*>): T {
        if (value == null) {
            value = block()
        }
        return value as T
    }
}