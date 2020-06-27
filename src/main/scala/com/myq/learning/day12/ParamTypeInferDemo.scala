package com.myq.learning.day12

/**
  * 基本介绍
  *
  * 参数推断省去类型信息（在某些情况下[需要有应用场景]，参数类型是可以推断出来的，如list=(1,2,3) list.map()
  * map中函数参数类型是可以推断的)，同时也可以进行相应的简写。
  *
  * 参数类型推断写法说明
  *
  * 1.参数类型是可以推断时，可以省略参数类型
  * 2.当传入的函数，只有单个参数时，可以省去括号
  * 3.如果变量只在=>右边只出现一次，可以用_来代替
  */
object ParamTypeInferDemo {
  def main(args: Array[String]): Unit = {
    //分别说明
    val list = List(1, 2, 3, 4)
    println(list.map((x: Int) => x + 1)) //(2,3,4,5)
    println(list.map((x) => x + 1))
    println(list.map(x => x + 1))
    println(list.map(_ + 1))

    /**
      * 应用案例的小结
      * 1.map是一个高阶函数，因此也可以直接传入一个匿名函数，完成map
      * 2.当遍历list时，参数类型是可以推断出来的，可以省略数据类型Intprintln(list.map((x)=>x + 1))
      * 3.当传入的函数，只有单个参数时，可以省去括号println(list.map(x=>x + 1))
      * 4.如果变量只在=>右边只出现一次，可以用_来代替println(list.map(_ + 1))
      */

    println(list.reduce(f1))
    println(list.reduce((n1: Int, n2: Int) => n1 + n2))
    println(list.reduce((n1, n2) => n1 + n2))
    val res = list.reduce(_ + _)

  }

  def f1(n1: Int, n2: Int): Int = {
    n1 + n2
  }
}
