package com.myq.learning.day10

/**
  * 扩展-视图 View
  * 基本介绍
  * Stream的懒加载特性，也可以对其他集合应用view方法来得到类似的效果，具有如下特点：
  * 1.view方法产出一个总是被懒执行的集合。
  * 2.view不会缓存数据，每次都要重新计算，比如遍历View时。
  */
object ViewDemo {
  def multiple(num: Int): Int = {
    num
  }

  def eq(i: Int): Boolean = {
    i.toString.equals(i.toString.reverse)
  }

  //说明: 没有使用view
  val viewSquares1 = (1 to 100)
    .map(multiple)
    .filter(eq)
  println(viewSquares1)
  //for (x <- viewSquares1) {}
  //使用view
  val viewSquares2 = (1 to 100)
    .view
    .map(multiple)
    .filter(eq)
  println(viewSquares2)

}
