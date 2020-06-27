package com.myq.learning.day12

/**
  * 进阶用法：实现类似while的until函数
  */
object AbstractControllDemo1 {
  def main(args: Array[String]): Unit = {
    var x = 10
    def until(condition: => Boolean)(block: => Unit): Unit = {
      //类似while循环，递归
      if (!condition) {
        block
        until(condition)(block)
      }
      //      println("x=" + x)
      //      println(condition)
      //      block
      //      println("x=" + x)
    }

    until(x == 0) {
      x -= 1
      println("x=" + x)
    }

  }
}
