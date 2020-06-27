package com.myq.learning.day7

/**
  * Scala接口的介绍:
  * 从面向对象来看，接口并不属于面向对象的范畴，Scala是纯面向对象的语言，在Scala中，没有接口。
  * Scala语言中，采用特质trait（特征）来代替接口的概念，也就是说，多个类具有相同的特征（特征）时，就可以将这个特质（特征）独立出来，
  * 采用关键字trait声明。 理解trait 等价于(interface + abstract class)
  *
  * 特质trait 的再说明:
  * 1.Scala提供了特质（trait），特质可以同时拥有抽象方法和具体方法，一个类可以实现/继承多个特质。
  * 2.特质中没有实现的方法就是抽象方法。类通过extends继承特质，通过with可以继承多个特质
  * 3.所有的java接口都可以当做Scala特质使用
  * 说明：和Java中的接口不太一样的是特质中的方法并不一定是抽象的，也可以有非抽象方法(即：实现了的方法)。
  *
  * 注意：可以通过编译后的代码详细了解trait的实现原理
  */
object TraitDemo {
  def main(args: Array[String]): Unit = {
    val c = new C
    c.say()
    c.sayH()
  }
}

trait P {
  def say()

  def sayH(): Unit ={
    println("aaaa")
  }
}

class C extends P{
  override def say(): Unit = {
    println("bbbb")
  }
}
