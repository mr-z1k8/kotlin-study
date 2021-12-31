package com.example.study.chapter.two.lambda

import kotlin.math.max

/**
 * list and set
 */
class Collection {

    /**
     * listOf: Immutable list
     * can't add,remove,modify
     */
    val list = listOf("a", "b", "b", "c", "d", "e")

    /**
     * Unlike list, the same element is not allowed
     */
    val set = setOf("a", "b", "c", "d", "e")

    /**
     * if list can mutable, use "mutableListOf"
     */
    val mutList = mutableListOf("a", "b", "b", "c", "d")

    /**
     * definition map
     * The defined map also immutable. if you need, can use "mutableMapOf"
     */
    val map = mapOf("apple" to 1, "banana" to 2, "orange" to 3)

    /**
     * java Uages:
     *  map.put("apple", 1);
     *  map.put("banana", 2);
     *  map.put("orange", 3);
     *  map.put("pear", 4);
     */
    fun getMap(): HashMap<String, Int> {
        val map = HashMap<String, Int>()
        map["apple"] = 1
        map["banana"] = 2
        map["orange"] = 3
        map["pear"] = 4
        return map
    }

    /**
     * lambda expression
     * Usage:
     * var maxLengthFruit = ""
     * for (fruit in fruits) {
     *  if (fruit.length > maxLengthFruit.length) {
     *      maxLengthFruit = fruit
     *  }
     * }
     */
    fun getFruit() {
        val fruits = listOf("apple", "banana", "orange", "pear")
        // "it" keyword , when params only one ,can use "it" instead.
        val maxLengthFruit = fruits.maxOf { it.length }
        println("max length fruit is $maxLengthFruit")
    }

    /**
     * use of "map" in list !!!
     */
    fun getLargeFruit() {
        val fruits = listOf("apple", "banana", "orange", "pear")
        // 1. "map" Map each element in the collection to another value
        // 2. "toUpperCase" transform to Capital
        val newFruits = fruits.map { it.toUpperCase() }
        for (fruit in newFruits) {
            println(fruit)
        }
    }

    /**
     * use of "filter" in list !!!
     */
    fun getLimitFruit() {
        val fruits = listOf("apple", "banana", "orange", "pear")
        // "filter" is filter
        val newFruits = fruits.filter { it.length < 5 }
            .map { it.toUpperCase() }
        for (fruit in newFruits) {
            println(fruit)
        }
    }

    /**
     * use of "any" and "all" in list
     */
    fun getConditionFruit() {
        val fruits = listOf("apple", "banana", "orange", "pear")
        val newFruits1 = fruits.any { it.length < 5 }
        val newFruits2 = fruits.all { it.length < 5 }
        println("any fruit length less than 5: $newFruits1 ,all fruit length less than 5: $newFruits2")
        //any fruit length small than 5: true ,all fruit length small then 5: false
    }
}