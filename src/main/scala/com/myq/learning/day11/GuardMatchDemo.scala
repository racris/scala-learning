package com.myq.learning.day11

/**
  * 基本介绍
  * 如果想要表达匹配某个范围的数据，就需要在模式匹配中增加条件守卫
  */
object GuardMatchDemo {
  def main(args: Array[String]): Unit = {
    for (ch <- "+-3!") {
      var sign = 0
      var digit = 0
      ch match {
        case '+' => sign = 1
        case '-' => sign = -1
        // 说明..
        case _ if ch.toString.equals("3") => digit = 3
        case _ => sign = 2
      }
      println(ch + " " + sign + " " + digit)
    }
  }
}
