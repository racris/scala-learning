package com.myq.learning.day3

import scala.util.control.Breaks._

object WhileBreak {
  def main(args: Array[String]): Unit = {
    //    breakable(op)
    var i = 0
    breakable {
      while (i < 10) {
        i += 1
        println("i=" + i)
        if (i == 8) {
          break()
        }
      }
    }
    println("hello")
  }
}
