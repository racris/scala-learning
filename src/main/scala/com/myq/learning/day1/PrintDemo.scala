package com.myq.learning.day1

object PrintDemo {
  def main(args: Array[String]): Unit = {
    val s1: String = "hello"
    val s2: String = "world"
    println(s1 + s2)
    val i: Int = 10
    val i1: Double = 2.32d
    printf("s1 : %s ,s2 : %s , i : %d,i1:%.2f", s1, s2, i, i1)
    printf(s"s1 = $s2")
    //${}大括号里可以使用表达式
    printf(s"s1 = ${s1 + s2}")
  }
}
