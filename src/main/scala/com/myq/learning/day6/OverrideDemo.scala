package com.myq.learning.day6

object OverrideDemo {
  def main(args: Array[String]): Unit = {
    val a = new A
    val b = new B
    println("a = " + a.age)
    println("b = " + b.age)

    //测试ModifierDemo里的private[day06]包中都可以访问pname属性
    val modifierDemo = new ModifierDemo
    println(modifierDemo.pname)
  }
}

class A {
  val age: Int = 10   //底层生成public age()
}

class B extends A {
  override val age: Int = 20
}