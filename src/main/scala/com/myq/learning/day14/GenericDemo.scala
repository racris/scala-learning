package com.myq.learning.day14

import com.myq.learning.day14.SeasonEm.SeasonEm

/**
  * 基本介绍
  *
  * 1.如果我们要求函数的参数可以接受任意类型。可以使用泛型，这个类型可以代表任意的数据类型。
  * 2.例如 List，在创建 List 时，可以传入整型、字符串、浮点数等等任意类型。那是因为 List 在 类定义时引用了泛型。
  * 比如在Java中：public interface List<E> extends Collection<E>
  */
object GenericDemo {

  def main(args: Array[String]): Unit = {
    /**
      * Scala泛型应用案例1
      * 要求:
      *
      * 编写一个Message类
      * 可以构建Int类型的Message,String类型的Message.
      * 要求使用泛型来完成设计,(说明：不能使用Any)
      */
    val mes1 = new StrMessage[String]("10")
    println(mes1.get)
    val mes2 = new IntMessage[Int](20)
    println(mes2.get)

    /**
      * Scala泛型应用案例2
      *
      * 要求
      * 请设计一个EnglishClass (英语班级类)，在创建EnglishClass的一个实例时，
      * 需要指定[ 班级开班季节(spring,autumn,summer,winter)、班级名称、班级类型]
      * 开班季节只能是指定的，班级名称为String, 班级类型是(字符串类型 "高级班", "初级班"..) 或者是 Int 类型(1, 2, 3 等)
      */
    val class1 = new EnglishClass[SeasonEm, String, String](SeasonEm.spring, "001班", "高级班")
    println(class1.classSeason + " " + class1.className + " " + class1.classType)

    val class2 = new EnglishClass[SeasonEm, String, Int](SeasonEm.spring, "002班", 1)
    println(class2.classSeason + " " + class2.className + " " + class2.classType)

    /**
      * Scala泛型应用案例3
      *
      * 要求
      * 定义一个函数，可以获取各种类型的 List 的中间index的值
      */
    // 定义一个函数，可以获取各种类型的 List 的中间index的值
    val list1 = List("jack",100,"tom")
    val list2 = List(1.1,30,30,41)
    println(getMidEle(list1))

  }

  // 定义一个方法接收任意类型的 List 集合
  def getMidEle[A](l: List[A])={
    l(l.length/2)
  }

}
// 在 Scala 定义泛型用[T]， s 为泛型的引用
abstract class Message[T](s: T) {
  def get: T = s
}
// 子类扩展的时候，约定了具体的类型
class StrMessage[String](msg: String) extends Message(msg)
class IntMessage[Int](msg: Int) extends Message(msg)

// Scala 枚举类型
object SeasonEm extends Enumeration {
  type SeasonEm = Value //自定义SeasonEm，是Value类型,这样才能使用
  val spring, summer, winter, autumn = Value
}
// 定义一个泛型类
class EnglishClass[A, B, C](val classSeason: A, val className: B, val classType: C)


