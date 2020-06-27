package com.myq.learning.day9

import scala.collection.mutable.ArrayBuffer

/**
  * 基本使用和应用案例
  *
  * //定义/声明
  * val arr2 = ArrayBuffer[Int]()
  * //追加值/元素
  * arr2.append(7)
  * //重新赋值
  * arr2(0) = 7
  * //学习集合的流程(创建,查询,修改,删除)
  */
object ArrayBufferDemo {
  val arr01 = ArrayBuffer[Any](3, 2, 5)

  println("arr01(1)=" + arr01(1))
  for (i <- arr01) {
    println(i)
  }
  println(arr01.length) //?
  println("arr01.hash=" + arr01.hashCode())
  arr01.append(90.0,13)
  println("arr01.hash=" + arr01.hashCode())

  arr01(1) = 89 //修改
  println("--------------------------")
  for (i <- arr01) {
    println(i)
  }

  //删除
  arr01.remove(0)
  println("--------------------------")
  for (i <- arr01) {
    println(i)
  }
  println("最新的长度=" + arr01.length)
}

/**
  * 变长数组分析小结:
  * 1.ArrayBuffer是变长数组，类似java的ArrayList
  * 2.val arr2 = ArrayBuffer[Int]() 也是使用的apply方法构建对象
  * 3.def append(elems: A*) { appendAll(elems) } 接收的是可变参数.
  * 4.每append一次，arr在底层会重新分配空间，进行扩容，arr2的内存地址会发生变化，也就成为新的ArrayBuffer
  */
