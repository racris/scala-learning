package com.myq.learning.day9

/**
  * 基本介绍
  * 元组也是可以理解为一个容器，可以存放各种相同或不同类型的数据。
  * 说的简单点，就是将多个无关的数据封装为一个整体，称为元组, 最多的特点灵活,对数据没有过多的约束。
  *
  * 注意：元组中最大只能有22个元素
  */
object TupleDemo {
  def main(args: Array[String]): Unit = {
    //元组的创建
    val tuple1 = (1, 2, 3, "hello", 4)
    println(tuple1)

    /**
      * 访问元组中的数据,可以采用顺序号（_顺序号），也可以通过索引（productElement）访问。
      */
    //元组的访问
    val t1 = (1, "a", "b", true, 2)
    println(t1._1) //访问元组的第一个元素 ，从1开始
    println(t1.productElement(0)) // 访问元组的第一个元素，从0开始

    //Tuple是一个整体，遍历需要调其迭代器。
    for (item <- t1.productIterator) {
      println(item)
    }
  }

  /**
    * 小结：
    *
    * 1.t1 的类型是 Tuple5类 是scala特有的类型
    * 2.t1 的类型取决于 t1 后面有多少个元素, 有对应关系，比如 4个元素=》Tuple4
    * 3.给大家看一个Tuple5 类的定义,大家就了然了
    * /*
    * final case class Tuple5[+T1, +T2, +T3, +T4, +T5](_1: T1, _2: T2, _3: T3, _4: T4, _5: T5)
    * extends Product5[T1, T2, T3, T4, T5]
    * {
    * override def toString() = "(" + _1 + "," + _2 + "," + _3 + "," + _4 + "," + _5 + ")"
    * }
    **/
    * 4.元组中最大只能有22个元素 即 Tuple1...Tuple22
    */
}
