package com.myq.learning.day12

/**
  * 基本介绍
  *
  * 函数作为一个变量传入到了另一个函数中，那么该作为参数的函数的类型是：function1，即：(参数类型) => 返回类型
  */
object FunctionAsParamDemo {
  def main(args: Array[String]): Unit = {
    //说明
    def plus(x: Int) = 3 + x
    //说明
    val result1 = Array(1, 2, 3, 4).map(plus(_))
    println(result1.mkString(","))

    /**
      * 应用实例小结
      *
      * 1.map(plus(_)) 中的plus(_) 就是将plus这个函数当做一个参数传给了map，_这里代表从集合中遍历出来的一个元素。
      *
      * 2.plus(_) 这里也可以写成 plus 表示对 Array(1,2,3,4) 遍历，将每次遍历的元素传给plus的 x
      * 3.进行 3 + x 运算后，返回新的Int ，并加入到新的集合 result1中
      * 4.def map[B, That](f: A => B) 的声明中的 f: A => B 一个函数
      */
  }
}
