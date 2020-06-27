package com.myq.learning.day9

import scala.collection.mutable

/**
  * 集是不重复元素的结合。集不保留顺序，默认是以哈希集实现
  *
  * Java中Set的回顾
  *
  * java中，HashSet是实现Set<E>接口的一个实体类，数据是以哈希表的形式存放的，里面的不能包含重复数据。
  * Set接口是一种不包含重复元素的 collection，HashSet中的数据也是没有顺序的。
  *
  * Scala中Set的说明
  *
  * 默认情况下，Scala 使用的是不可变集合，如果你想使用可变集合，需要引用 scala.collection.mutable.Set 包
  */
object SetDemo {
  def main(args: Array[String]): Unit = {
    //Set不可变集合的创建
    val set = Set(1, 2, 3) //不可变
    println(set)

    //Set可变集合的创建
    import scala.collection.mutable.Set
    val mutableSet = Set(1, 2, 3) //可变

    //可变集合的元素添加
    /**
      * 说明：如果添加的对象已经存在，则不会重复添加，也不会报错
      */
    mutableSet.add(4) //方式1
    mutableSet += 6  //方式2
    mutableSet.+=(5) //方式3

    val set02 = mutable.Set(1,2,4,"abc")
    set02.add(90)
    set02 += 78
    set02 += 90
    println(set02)

    //可变集合的元素删除
    /**
      * 说明：如果删除的对象不存在，则不生效，也不会报错
      */
    set02 -= 2 // 操作符形式
    set02.remove("abc") // 方法的形式，scala的Set可以直接删除值
    println(set02)

    //集Set的遍历
    val set03 = mutable.Set(1, 2, 4, "abc")
    for(x <- set03) {
      println(x)
    }

  }
}
