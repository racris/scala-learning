package com.myq.learning.day10

object HighFuncDemo {

  def main(args: Array[String]): Unit = {
    val res = test(sum, 6.0)
    println("res=" + res)
    test2(sayOK)
  }

  /**
    * 说明：
    * 1.test就是一个高阶函数
    * 2.f:Double => Double表示一个函数，该函数可以接收一个Double，返回一个Double
    * 3.n1：Double 普通参数
    * 4.f(n1)在test函数中执行传入的函数
    *
    * @param f
    * @param n1
    * @return
    */
  def test(f: Double => Double, n1: Double) = {
    f(n1)
  }

  def sum(d: Double): Double = {
    d + d
  }

  def test2(f: () => Unit) = {
    f()
  }

  def sayOK() = {
    println("sayOKKK...")
  }


}
