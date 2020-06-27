package com.myq.learning.day12

/**
  * 基本介绍
  *
  * 能够接受函数作为参数的函数，叫做高阶函数 (higher-order function)。可使应用程序更加健壮。
  */
object HigherOrdeFuncDemo {
  //高阶函数基本使用
  def main(args: Array[String]): Unit = {
    //test 就是一个高阶函数，它可以接收f: Double => Double
    def test(f: Double => Double, n1: Double) = {
      f(n1)
    }
    //sum 是接收一个Double,返回一个Double
    def sum(d: Double): Double = {
      d + d
    }
    val res = test(sum, 6.0)
    println("res=" + res)

    //高阶函数可以返回函数类型
    def minusxy(x: Int) = {
      (y: Int) => x - y //匿名函数
    }
    val result3 = minusxy(3)(5)
    println(result3)
    //高级函数案例的小结
    /**
      * 说明: def minusxy(x: Int) = (y: Int) => x - y
      * 1.函数名为 minusxy
      *2. 该函数返回一个匿名函数
      * (y: Int) = > x -y
      *
      * 说明:val result3 = minusxy(3)(5)
      * 1.minusxy(3)执行minusxy(x: Int)得到 (y: Int) => 3 - y 这个匿名函
      * 2.minusxy(3)(5)执行 (y: Int) => x - y 这个匿名函数
      * 3.也可以分步执行: val f1 = minusxy(3);   val res = f1(90)
      */

  }
}
