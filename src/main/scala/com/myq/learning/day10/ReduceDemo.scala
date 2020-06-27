package com.myq.learning.day10

/**
  * 化简：
  * 化简：将二元函数引用于集合中的函数,。
  * 上面的问题当然可以使用遍历list方法来解决，这里我们使用scala的化简方式来完成。
  */
object ReduceDemo {
  /**
    * 需求:
    * val list = List(1, 20, 30, 4 ,5) , 求出list的和
    */
  def main(args: Array[String]): Unit = {
    val list = List(1, 20, 30, 4, 5)
    val res = list.reduceLeft(sum)
    println("res=" + res)

    //练习
    val list1 = List(1, 2, 3, 4 ,5)
    println(list1.reduceLeft(minus)) // 输出-13
    println(list1.reduceRight(minus)) //输出3
    println(list1.reduce(minus))//-13,默认与reduceLeft一样
  }
  def minus( num1 : Int, num2 : Int ): Int = {
    num1 - num2
  }
  def sum(n1: Int, n2: Int): Int = {
    n1 + n2
  }
  /**
    * 说明:
    * 1.def reduceLeft[B >: A](@deprecatedName('f) op: (B, A) => B): B
    * 2.reduceLeft(f) 接收的函数需要的形式为 op: (B, A) => B): B
    * 3.reduceleft(f) 的运行规则是 从左边开始执行将得到的结果返回给第一个参数
    * 4.然后继续和下一个元素运行，将得到的结果继续返回给第一个参数，继续..
    * 5.即: //((((1 + 2)  + 3) + 4) + 5) = 15
    */
}
