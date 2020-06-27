package com.myq.learning.day13

object RecursiveDemo2 {
  def main(args: Array[String]): Unit = {
    //使用函数式编程方式-递归
    //求最大值
    def max(xs: List[Int]): Int = {
      if (xs.isEmpty)
        throw new java.util.NoSuchElementException
      if (xs.size == 1)
        xs.head
      else if (xs.head > max(xs.tail)) xs.head else max(xs.tail)
    }

    //翻转字符串
    //Str = "ab"
    def reverse(xs: String): String =
      if (xs.length == 1) xs else reverse(xs.tail) + xs.head

    //求阶乘
    def factorial(n: Int): Int =
      if (n == 0) 1 else n * factorial(n - 1)

  }
}
