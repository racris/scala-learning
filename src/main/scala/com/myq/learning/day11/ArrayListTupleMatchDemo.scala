package com.myq.learning.day11

/**
  * 基本介绍
  * 1.Array(0) 匹配只有一个元素且为0的数组。
  * 2.Array(x,y) 匹配数组有两个元素，并将两个元素赋值为x和y。当然可以依次类推Array(x,y,z) 匹配数组有3个元素的等等....
  * 3.Array(0,_*) 匹配数组以0开始
  */
object ArrayListTupleMatchDemo {
  def main(args: Array[String]): Unit = {
    //匹配数组
    //说明：
    //通过增加和删除for循环的数组，来看代码运行的结果,加强对匹配数组的理解
    for (arr <- Array(Array(0), Array(1, 0), Array(0, 1, 0),
      Array(1, 1, 0), Array(1, 1, 0, 1))) {
      val result = arr match {
        case Array(0) => "0"
        case Array(x, y) => x
        case Array(0, _*) => "以0开头和数组"
        case _ => "什么集合都不是"
      }
      println("result = " + result)
    }

    //匹配列表
    for (list <- Array(List(0), List(1, 0), List(0, 0, 0), List(1, 0, 0))) {
      val result = list match {
        case 0 :: Nil => "0" //
        case x :: y :: Nil => x + " " + y //
        case 0 :: tail => "0 ..." //
        case _ => "something else"
      }
      println(result)
    }

    // 元组匹配
    for (pair <- Array((0, 1), (1, 0), (1, 1),(1,0,2))) {
      val result = pair match { //
        case (0, _) => "0 ..." //
        case (y, 0) => y //
        case _ => "other" //.
      }
      println(result)
    }

  }
}
