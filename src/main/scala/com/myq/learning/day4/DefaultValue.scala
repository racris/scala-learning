package com.myq.learning.day4

object DefaultValue {

  def main(args: Array[String]): Unit = {
    //带名参数在多个参数时可以指定传入某个特定的
    defaultValue(name = "bbb")
  }

  //函数可以有默认值aaa
  def defaultValue(name: String = "aaa"): Unit ={
    println(name)
  }
}
