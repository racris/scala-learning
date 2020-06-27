package com.myq.learning.day10

/**
  * 基本介绍
  *
  * 扫描，即对某个集合的所有元素做fold操作，但是会把产生的所有中间结果放置于一个集合中保存
  */
object ScanDemo {
  def main(args: Array[String]): Unit = {
    def minus(num1: Int, num2: Int): Int = {
      num1 - num2
    }
    //5 (1,2,3,4,5) =>(5,4,2,-1,-5,-10)
    val i8 = (1 to 5).scanLeft(5)(minus) //IndexedSeq[Int]
    println(i8)
    def add(num1: Int, num2: Int): Int = {
      num1 + num2
    }
    //5 (1,2,3,4,5) =>(5,6,8, 11,15,20)
    val i9 = (1 to 5).scanLeft(5)(add) //IndexedSeq[Int]
    println(i9)

    val i11 = (1 to 3).scanLeft(3)(test)
    println(i11)
  }

  def test(num1: Int, num2: Int): Int = {
    num1 * num2
  }
}
