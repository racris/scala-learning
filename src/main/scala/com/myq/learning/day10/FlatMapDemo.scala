package com.myq.learning.day10

/**
  * flatmap映射：flat即压扁，压平，扁平化映射
  *
  * flatmap：flat即压扁，压平，扁平化，效果就是将集合中的每个元素的子元素映射到某个函数并返回新的集合。
  */
object FlatMapDemo {

  def main(args: Array[String]): Unit = {
    val names = List("Alice", "Bob", "Nick")
    println(names.flatMap(upper))
  }
  def upper( s : String ) : String = {
    s. toUpperCase
  }
}
