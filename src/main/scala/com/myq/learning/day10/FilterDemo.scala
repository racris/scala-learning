package com.myq.learning.day10

/**
  * filter：将符合要求的数据(筛选)放置到新的集合中
  *
  *
  * 应用案例：将  val names = List("Alice", "Bob", "Nick") 集合中首字母为'A'的筛选到新的集合。
  */
object FilterDemo {
  def main(args: Array[String]): Unit = {
    val names = List("Alice", "Bob", "Nick")
    val names2 = names.filter(startA)
    println("names=" + names2)
  }
  def startA(s:String): Boolean = {
    s.startsWith("A")
  }
}
