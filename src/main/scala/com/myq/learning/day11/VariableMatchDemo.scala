package com.myq.learning.day11

/**
  * 基本介绍
  * 如果在case关键字后跟变量名，那么match前表达式的值会赋给那个变量
  */
object VariableMatchDemo {
  def main(args: Array[String]): Unit = {
    val ch = 'V'
    ch match {
      case '+' => println("ok~")
      case mychar => println("ok~" + mychar)
      case _ => println("ok~~")
    }

  }
}
