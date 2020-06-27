package com.myq.learning.day9

import scala.collection.mutable.ListBuffer

/**
  * ListBuffer是可变的list集合，可以添加，删除元素,ListBuffer属于序列
  * //追一下继承关系即可
  * Seq var listBuffer = ListBuffer(1,2)
  */
object ListBufferDemo {
  def main(args: Array[String]): Unit = {
    val lst0 = ListBuffer[Int](1, 2, 3)

    println("lst0(2)=" + lst0(2))
    for (item <- lst0) {
      println("item=" + item)
    }

    val lst1 = new ListBuffer[Int]
    lst1 += 4
    lst1.append(5)

    lst0 ++= lst1
    val lst2 = lst0 ++ lst1
    val lst3 = lst0 :+ 5

    println("=====删除=======")
    println("lst1=" + lst1)
    lst1.remove(1)
    for (item <- lst1) {
      println("item=" + item)
    }

  }
}
