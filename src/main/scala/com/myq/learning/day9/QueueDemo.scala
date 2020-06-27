package com.myq.learning.day9

import scala.collection.mutable

/**
  * 队列的说明
  *
  * 1.队列是一个有序列表，在底层可以用数组或是链表来实现。
  * 2.其输入和输出要遵循先入先出的原则。即：先存入队列的数据，要先取出。后存入的要后取出
  * 3.在Scala中，由设计者直接给我们提供队列类型使用。
  * 4.在scala中, 有 scala.collection.mutable.Queue 和 scala.collection.immutable.Queue , 一般来说，我们在开发中通常使用可变集合中的队列。
  *
  * import scala.collection.mutable
  * //说明: 这里的Int是泛型，表示q1队列只能存放Int类型
  * //如果希望q1可以存放其它类型，则使用 Any 即可。
  * val q1 = new mutable.Queue[Int]
  * println(q1)
  */
object QueueDemo {
  def main(args: Array[String]): Unit = {
    val q1 = new mutable.Queue[Int]
    q1 += 20 // 底层?
    println(q1)

    q1 ++= List(2,4,6) //
    println(q1)

    //q1 += List(1,2,3) //泛型为Any才ok
    println(q1)
  }
  //补充操作符重载...
  val cat = new Cat
  println(cat.age)
  cat += 9
  println(cat.age)

//  队列 Queue-删除和加入队列元素
  val q1 = new mutable.Queue[Int]//
  q1 += 12
  q1 += 34
  q1 ++= List(2,9)
  q1.dequeue() //队列头
  println(q1)
  q1.enqueue(20,60) //队列位
  println(q1)

//  返回队列的第一个元素
  println(q1.head)
//  返回队列最后一个元素
  println(q1.last)

  /**返回队列的尾部
    * 即：返回除了第一个以外剩余的元素， 可以级联使用，这个在递归时使用较多。
    */
  println(q1.tail)
  println(q1.tail.tail)


}

/**
  * 说明
  *
  * 按照进入队列的顺序删除元素（队列先进先出）--出队列
  * 按照队列的算法，会将数据添加到队列的最后。--入队列
  */


class Cat {
  var age: Int = 10
  def +=(n:Int): Unit = {
    this.age += n
    println("xxx")
  }
}
