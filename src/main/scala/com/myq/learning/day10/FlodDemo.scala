package com.myq.learning.day10

/**
  * 基本介绍
  *
  * fold函数将上一步返回的值作为函数的第一个参数继续传递参与运算，直到list中的所有元素被遍历。
  *
  * 1.可以把reduceLeft看做简化版的foldLeft。
  * 如何理解:def reduceLeft[B >: A](@deprecatedName('f) op: (B, A) => B): B =
  * if (isEmpty) throw new UnsupportedOperationException("empty.reduceLeft")
  * else tail.foldLeft[B](head)(op)
  * 大家可以看到. reduceLeft就是调用的foldLeft[B](head)，并且是默认从集合的head元素开始操作的。
  * 2.相关函数：fold，foldLeft，foldRight，可以参考reduce的相关方法理解
  */
object FlodDemo {
  def main(args: Array[String]): Unit = {
    // 折叠
    val list = List(1, 2, 3, 4)
    def minus(num1: Int, num2: Int): Int = {
      num1 - num2
    }
    println(list.foldLeft(5)(minus)) // 函数的柯里化
    println(list.foldRight(5)(minus)) //

    //foldLeft和foldRight 缩写方法分别是：/:和:\
    val list4 = List(1, 9, 2, 8)
    var i6 = (1 /: list4) (minus) // =等价=> list4.foldLeft(1)(minus)
    println(i6) // 输出?
    i6 = (100 /: list4) (minus)
    println(i6) // 输出?
    i6 = (list4 :\ 10) (minus) // list4.foldRight(10)(minus)
    println(i6) // 输出?

  }
}
