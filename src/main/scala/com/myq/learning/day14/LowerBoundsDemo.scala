package com.myq.learning.day14

/**
  * 下界(Lower Bounds)介绍和使用
  *
  * Java中下界
  * 在 Java 泛型里表示某个类型是 A类型的父类型，使用 super 关键字
  *
  * <T super A>
  * //或用通配符的形式：
  * <? super A>
  *
  * scala中下界
  * 在 scala 的下界或下限，使用 >: 关键字，语法如下：
  *
  * [T >: A]
  * //或用通配符:
  * [_ >: A]
  */
object LowerBoundsDemo {
  /**
    * 下界(Lower Bounds)介绍和使用
    * scala中下界的使用小结
    *
    * def biophony[T >: Animal](things: Seq[T]) = things
    *
    * 1.对于下界，可以传入任意类型
    * 2.传入和Animal直系的，是Animal父类的还是父类处理，是Animal子类的按照Animal处理
    * 3.和Animal无关的，一律按照Object处理
    * 4.也就是下界，可以随便传，只是处理是方式不一样
    * 5.不能使用上界的思路来类推下界的含义
    *
    */
  def main(args: Array[String]): Unit = {

    biophony(Seq(new Earth, new Earth)).map(_.sound())

    biophony(Seq(new Animal, new Animal)).map(_.sound())
    biophony(Seq(new Bird, new Bird)).map(_.sound())

    val res = biophony(Seq(new Bird))

    val res2 = biophony(Seq(new Object))
    val res3 = biophony(Seq(new Moon))
    println("\nres2=" + res2)
    println("\nres3=" + res2)

  }

  def biophony[T >: Animal](things: Seq[T]) = things

}

class Moon {}

