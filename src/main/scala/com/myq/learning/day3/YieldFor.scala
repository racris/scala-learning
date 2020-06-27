package com.myq.learning.day3

object YieldFor {
  def main(args: Array[String]): Unit = {
    //将1到3进行遍历，将每次循环得到的i，放入到集合Vector中，并返回给res
    val res = for (i <- 1 to 3) yield i
    println(res)
  }
}
