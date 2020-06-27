package com.myq.learning.day10

/**
  * 扩展-迭代器
  * 基本说明
  * 通过iterator方法从集合获得一个迭代器，通过while循环和for表达式对集合进行遍历.(学习使用迭代器来遍历)
  */
object IteratorDemo {

  /**
    * 小结
    *
    * 1)  iterator 的构建实际是 AbstractIterator 的一个匿名子类，该子类提供了
    * /*
    * def iterator: Iterator[A] = new AbstractIterator[A] {
    * var these = self
    * def hasNext: Boolean = !these.isEmpty
    * def next(): A =
    **/
    * 2)该AbstractIterator 子类提供了  hasNext next 等方法.
    * 3)因此，我们可以使用 while的方式，使用hasNext next 方法变量
    *
    */
  def main(args: Array[String]): Unit = {
    val iterator = List(1, 2, 3, 4, 5).iterator // 得到迭代器
    println("--------遍历方式1 -----------------")
    while (iterator.hasNext) {
      println(iterator.next())
    }
    println("--------遍历方式2 for -----------------")
    for(enum <- iterator) {
      println(enum) //
    }

  }
}
