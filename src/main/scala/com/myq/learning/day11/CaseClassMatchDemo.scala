package com.myq.learning.day11

/**
  * 样例类
  *
  * 基本介绍
  *
  * 1.样例类仍然是类
  * 2.样例类用case关键字进行声明。
  * 3.样例类是为模式匹配而优化的类
  * 4.构造器中的每一个参数都成为val——除非它被显式地声明为var（不建议这样做）
  *
  * 5.在样例类对应的伴生对象中提供apply方法让你不用new关键字就能构造出相应的对象
  * 6.提供unapply方法让模式匹配可以工作
  * 7.将自动生成toString、equals、hashCode和copy方法(有点类似模板类，直接给生成，供程序员使用)
  * 8.除上述外，样例类和其他类完全一样。你可以添加方法和字段，扩展它们
  */
object CaseClassMatchDemo {
  def main(args: Array[String]): Unit = {
    /**
      * demo1:
      * 当我们有一个类型为Amount的对象时，可以用模式匹配来匹配他的类型，
      * 并将属性值绑定到变量(即：把样例类对象的属性值提取到某个变量,该功能有用)
      */
    for (amt <- Array(Dollar(1000.0), Currency(1000.0, "RMB"), NoAmount)) {
      val result = amt match {
        //说明
        case Dollar(v) => "$" + v
        //说明
        case Currency(v, u) => v + " " + u
        case NoAmount => ""
      }
      println(amt + ": " + result)
    }

    /**
      * demo2:
      * 样例类的copy方法和带名参数
      * copy创建一个与现有对象值相同的新对象，并可以通过带名参数来修改某些属性。
      */
    val amt = Currency(29.95, "RMB")
    val amt1 = amt.copy() //创建了一个新的对象，但是属性值一样
    val amt2 = amt.copy(value = 19.95) //创建了一个新对象，但是修改了货币单位
    val amt3 = amt.copy(unit = "英镑")//..
    println(amt)
    println(amt2)
    println(amt3)


  }
}

//说明: 这里的 Dollar，Currencry, NoAmount  是样例类。
abstract class Amount
case class Dollar(value: Double) extends Amount
case class Currency(value: Double, unit: String) extends Amount
case object NoAmount extends Amount
