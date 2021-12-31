package com.example.study.chapter.ten.generic.Inversion

interface Transformer<T> {

    fun onTransform(t: T): String
}


/**
 * Inversion.(逆变)
 *
 * in: T only can to appear in the in position, can't out position.
 *
 * If we define a generic class of MyClass<T>, where A is child type of B,
 * and MyClass<B> is child type of MyClass<A>, then we can say that MyClass is inversion on the generic type of T.
 */
interface Transformer2<in T>{

    fun onTransform(t: T): String
}


/**
 * Principle
 */
interface Transformer3<in T> {

    /**
     * @UnsafeVariance 注解: 让编译器可以正常编译通过
     * Inversion does not allow t to appear in the return position.(i.e. out position)
     */
    fun onTransform(name: String , age :Int) : @UnsafeVariance T
}