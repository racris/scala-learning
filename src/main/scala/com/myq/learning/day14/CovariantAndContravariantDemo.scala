package com.myq.learning.day14

/**
  * 基本介绍
  *
  * 1.Scala的协变(+)，逆变(-)，协变covariant、逆变contravariant、不可变invariant
  *
  * 2.对于一个带类型参数的类型，比如 List[T]，如果对A及其子类型B，满足 List[B]也符合List[A]的子类型，那么就称为covariance(协变) ，
  * 如果 List[A]是 List[B]的子类型，即与原来的父子关系正相反，则称为contravariance(逆变)。
  * 如果一个类型支持协变或逆变，则称这个类型为variance(翻译为可变的或变型)，否则称为invariance(不可变的)
  * 3.在Java里，泛型类型都是invariant，比如 List<String> 并不是 List<Object> 的子类型。
  * 而scala支持，可以在定义类型时声明(用加号表示为协变，减号表示逆变)，
  * 如: trait List[+T] // 在类型定义时声明为协变这样会把List[String]作为List[Any]的子类型。
  */
object CovariantAndContravariantDemo {
  def main(args: Array[String]): Unit = {
    val t: Temp1[Super] = new Temp1[Sub]("hello world1")  //协变
    val t1: Temp2[Sub] = new Temp2[Super]("hello world1") //逆变

  }
}

class Temp[A](title: String) { //Temp3[+A] //Temp[-A]
  override def toString: String = {
    title
  }
}
//协变
class Temp1[+A](title: String) { //Temp3[+A] //Temp[-A]
  override def toString: String = {
    title
  }
}
//逆变
class Temp2[-A](title: String) { //Temp3[+A] //Temp[-A]
  override def toString: String = {
    title
  }
}
//支持协变
class Super

class Sub extends Super
