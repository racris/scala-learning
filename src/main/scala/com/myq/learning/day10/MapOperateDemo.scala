package com.myq.learning.day10

/**
  * 深刻理解map映射函数的机制-模拟实现
  */
object MapOperateDemo {
  def main(args: Array[String]): Unit = {
    val list1 = List(3, 5, 7)
    def f1(n1: Int): Int = {
      println("xxx")
      2 * n1
    }
    val list2 = list1.map(f1)
    println(list2)

    val myList = MyList()
    val myList2 = myList.map(f1)
    println("myList2=" + myList2)
    println("myList=" + myList.list1)

  }
}

class MyList {
  var list1 = List(3, 5, 7)
  var list2 = List[Int]()
  def map(f:Int=>Int): List[Int] = {
    for (item<-list1) {
      list2 = list2 :+ f(item)
    }
    list2
  }
}
object MyList {
  def apply(): MyList = new MyList()
}
