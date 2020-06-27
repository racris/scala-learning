package com.myq.learning.day11

/**
  * 基本介绍
  * for循环也可以进行模式匹配.
  */
object ForDemo {
  def main(args: Array[String]): Unit = {
    val map = Map("A"->1, "B"->0, "C"->3)
    for ( (k, v) <- map ) {
      println(k + " -> " + v)
    }
    //说明
    for ((k, 0) <- map) {
      println(k + " --> " + 0)
    }
    //说明
    for ((k, v) <- map if v == 0) {
      println(k + " ---> " + v)
    }

  }
}
