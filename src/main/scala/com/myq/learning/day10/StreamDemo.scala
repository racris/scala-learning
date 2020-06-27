package com.myq.learning.day10

/**
  * 扩展-流 Stream
  * 基本说明
  * stream是一个集合。这个集合，可以用于存放无穷多个元素，但是这无穷个元素并不会一次性生产出来，
  * 而是需要用到多大的区间，就会动态的生产，末尾元素遵循lazy规则(即：要使用结果才进行计算的) 。
  */
object StreamDemo {
  def main(args: Array[String]): Unit = {
    //创建Stream对象
    def numsForm(n: BigInt) : Stream[BigInt] = n #:: numsForm(n + 1)
    val stream1 = numsForm(1)
    /**
      * 说明
      * 1.Stream 集合存放的数据类型是BigInt
      * 2.numsForm 是自定义的一个函数，函数名是程序员指定的。
      * 3.创建的集合的第一个元素是 n , 后续元素生成的规则是 n + 1
      * 4.后续元素生成的规则是可以程序员指定的 ，比如 numsForm( n * 4)...
      *
      * //注意：如果使用流集合，就不能使用last属性，如果使用last集合就会进行无限循环
      */
    println(stream1)
    //取出第一个元素
    println("head=" + stream1.head) //
    println(stream1.tail) //
    println(stream1) //?

    /**
      * 使用map映射stream的元素并进行一些计算
      */
    //创建Stream
    def multi(x:BigInt) : BigInt = {
      x * x
    }
    println(numsForm(5).map(multi)) //? (25,?)

  }
}
