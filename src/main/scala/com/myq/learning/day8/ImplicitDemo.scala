package com.myq.learning.day8

/**
  * 隐式转换的注意事项和细节
  *
  * 1.隐式转换函数的函数名可以是任意的，隐式转换与函数名称无关，只与函数签名（函数参数类型和返回值类型）有关。
  *
  * 2.隐式函数可以有多个(即：隐式函数列表)，但是需要保证在当前环境下，只有一个隐式函数能被识别
  */
object ImplicitDemo {
  /**
    * 隐式值也叫隐式变量，将某个形参变量标记为implicit，所以编译器会在方法省略隐式参数的情况下去搜索作用域内的隐式值作为缺省参数
    */
  implicit val str1: String = "jack" //隐式值
  def hello(implicit name: String): Unit = {
    println(name + " hello")
  }
  hello //调用.不带()

}
