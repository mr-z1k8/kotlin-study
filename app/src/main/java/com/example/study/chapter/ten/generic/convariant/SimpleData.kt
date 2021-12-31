package com.example.study.chapter.ten.generic.convariant

class SimpleData<T> {

    private var data: T? = null

    fun set(data: T) {
        this.data = data
    }

    fun get(): T? {
        return data
    }

}

/**
 * Convariant.(协变)
 * If we define a generic class of MyClass<T>, where A is child type of B,
 * and MyClass<A> is child type of MyClass<B>, then we can say that MyClass is covariant on the generic type of T.
 *
 * How to do make MyClass<A> is subtype of MyClass <B> ?  can set T only can be readed.
 *
 * out: T only can be output
 *
 * when use of out, T only can be readed.
 */
class SimpleData2<out T>(private val data: T) {

    fun get(): T? {
        return data
    }
}