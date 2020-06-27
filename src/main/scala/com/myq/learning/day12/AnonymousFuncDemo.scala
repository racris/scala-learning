package com.myq.learning.day12

/**
  * 基本介绍
  *
  * 没有名字的函数就是匿名函数，可以通过函数表达式来设置匿名函数
  */
object AnonymousFuncDemo {
  def main(args: Array[String]): Unit = {
    /**
      * 说明
      * 1.(x: Double) => 3 * x 就是匿名函数
      * 2.(x: Double) 是形参列表， => 是规定语法表示后面是函数体， 3 * x 就是函数体，如果有多行，可以 {} 换行写.
      * 3.triple 是指向匿名函数的变量。
      */
    val triple = (x: Double) => 3 * x
    println(triple(3))

    //应用例子
    val f1 = (n1: Int, n2: Int ) => {
      println("匿名函数被调用")
      n1 + n2
    }
    println("f1类型=" + f1)
    println(f1(10, 30))

  }
}
