package com.myq.learning.day13

/**
  * 使用函数式编程方式-递归
  *
  * 函数式编程的重要思想就是尽量不要产生额外的影响,上面的代码就不符合函数式编程的思想, 下面我们看看使用函数式编程方式来解决(Scala提倡的方式)
  */
object RecursiveDemo1 {
  def main(args: Array[String]): Unit = {
    // 递归的方式来解决
    def mx(num:BigInt,sum:BigInt):BigInt = {
      if(num <= 99999999l) return mx(num+1,sum + num)
      else return sum
    }

    //测试
    var num = BigInt(1)
    var sum = BigInt(0)
    var res = mx(num,sum)
    println("res=" + res)

  }
}
