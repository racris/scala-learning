package com.myq.learning.day2

class DataType{
  //1.在scala中有一个根类型Any，它是所有类的父类
  //2.scala中一切皆为对象，分为两大类AnyVal（值类型）、AnyRef（引用类型），他们都是Any的子类
  //3.Null类型是scala的特别类型，它只有一个值null，它是bottom class，是所有AnyRef类型的子类
  //4.Nothing类型也是bottom class。它是所有类的子类，在开发中通常可以将Nothing类型的值返回给任意变量或者函数，这里抛出异常用得很多
}

object DataType {

  def main(args: Array[String]): Unit = {
    say
    say()
  }

  def say() : Unit = {
    println("hello")
  }
}
