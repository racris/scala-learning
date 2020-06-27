package com.myq.learning.day3

class ForDemo {

}

/**
  * for循环控制
  */
object ForDemo {
  def main(args: Array[String]): Unit = {
    //基本案例
    //循环守卫，即循环保护式（也称条件判断式，守卫）。保护式为true则进入循环体内部，为false则跳过，类似于continue
    for (i <- 1 to 3 if i != 2) {
      println(i + " ")
    }

    for (i <- 1 to 3; j = 4 - i) {
      println(j + " ")
    }
    //等价于下面
    /*for (i <- 1 to 3) {
      var j = 4 - i
      println(j + " ")
    }*/
    //还可以写成
    for {i <- 1 to 3
         j = 4 - i} {
      println(j + " ")
    }

    println("==============")
    //步长控制,控制步长为2
    for (i <- Range(1, 10, 2)) {
      println(i + " ")
    }
  }
}