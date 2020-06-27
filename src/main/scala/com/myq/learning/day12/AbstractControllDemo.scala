package com.myq.learning.day12

import scala.util.control.Breaks._

/**
  * 控制抽象基本介绍
  *
  * 控制抽象是这样的函数，满足如下条件
  * 1.参数是函数
  * 2.函数参数没有输入值也没有返回值
  */
object AbstractControllDemo {
  def main(args: Array[String]): Unit = {
    /**
      * 需求
      *
      * 如何实现将一段代码(从形式上看)，作为参数传递给高阶函数，在高阶函数内部执行这段代码. 其使用的形式如 breakable{}
      */
    var n = 10
    breakable {
      while (n <= 20) {
        n += 1
        if (n == 18) {
          break()
        }
      }
    }

    /*def myRunInThread(f1: () => Unit) = {
      new Thread {
        override def run(): Unit = {
          f1()
        }
      }.start()
    }*/

    myRunInThread {
      () =>
        println("干活咯！5秒完成...")
        Thread.sleep(5000)
        println("干完咯！")
    }

    def myRunInThread(f1: => Unit): Unit = {
      //说明 
      new Thread {
        override def run(): Unit = {
          f1
        }
      }.start()
    }

    //简化处理，省略()，如下形式
    myRunInThread { //说明    println("干活咯！5秒完成...")
      Thread.sleep(5000)
      println("干完咯！")
    }

  }
}
