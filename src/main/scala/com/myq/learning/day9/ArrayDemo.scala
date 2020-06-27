package com.myq.learning.day9

/**
  * 第一种方式定义数组
  * 这里的数组等同于Java中的数组,中括号的类型就是数组的类型
  * val arr1 = new Array[Int](10)
  * //赋值,集合元素采用小括号访问
  * arr1(1) = 7
  *
  * 第二种方式定义数组
  *
  * 在定义数组时，直接赋值
  * //使用apply方法创建数组对象
  * val arr1 = Array(1, 2)
  */
object ArrayDemo {
  //第一种方式
  val arr01 = new Array[Int](4)
  println(arr01.length)

  println("arr01(0)=" + arr01(0))
  for (i <- arr01) {
    println(i)
  }
  println("--------------------")
  arr01(3) = 10
  for (i <- arr01) {
    println(i)
  }

  //第二种方式
  var arr02 = Array(1, 3, "xxx")
  for (i <- arr02) {
    println(i)
  }

}
