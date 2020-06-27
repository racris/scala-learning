package com.myq.learning.day13

import java.text.SimpleDateFormat
import java.util.Date


/**
  * Scala提倡函数式编程(递归思想)
  * 先说下编程范式:
  * 1.在所有的编程范式中，面向对象编程（Object-Oriented Programming）无疑是最大的赢家。
  * 2.但其实面向对象编程并不是一种严格意义上的编程范式，严格意义上的编程范式分为：
  * 命令式编程（Imperative Programming）、函数式编程（Functional Programming）和逻辑式编程（Logic Programming）。
  * 面向对象编程只是上述几种范式的一个交叉产物，更多的还是继承了命令式编程的基因。
  * 3.在传统的语言设计中，只有命令式编程得到了强调，那就是程序员要告诉计算机应该怎么做。而递归则通过灵巧的函数定义，告诉计算机做什么。
  * 因此在使用命令式编程思维的程序中，是现在多数程序采用的编程方式，递归出镜的几率很少，而在函数式编程中，大家可以随处见到递归的方式。
  */
object RecursiveDemo {
  def main(args: Array[String]): Unit = {
    //scala中循环不建议使用while和do...while,而建议使用递归。
    val now: Date = new Date()
    val dateFormat: SimpleDateFormat =
      new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    val date = dateFormat.format(now)
    println("date=" + date) //输出时间
    var res = BigInt(0)
    var num = BigInt(1)
    var maxVal = BigInt(99999999l) //BigInt(99999999l)[测试效率大数]
    while (num <= maxVal) {
      res += num
      num += 1
    }
    println("res=" + res)

  }
}
