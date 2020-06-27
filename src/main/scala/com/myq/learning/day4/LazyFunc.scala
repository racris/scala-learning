package com.myq.learning.day4

object LazyFunc {

  def main(args: Array[String]): Unit = {
    //懒加载
    lazy val s = sum(10, 20)
    println("============")
    println("s=" + s)
  }

  /**
    * 注意事项和细节
    * 1.lazy不能修饰var类型的变量
    * 2.不但是在调用函数时，加了lazy ,会导致函数的执行被推迟，我们在声明一个变量时，如果给声明了lazy ,那么变量值得分配也会推迟。 比如 lazy val i = 10
    *
    */

  def sum(n1: Int, n2: Int) = {
    println("执行sum函数")
    n1 + n2
  }
}
