package com.myq.learning.day12

/**
  * 基本介绍
  *
  * 1.函数编程中，接受多个参数的函数都可以转化为接受单个参数的函数，这个转化过程就叫柯里化
  *
  * 2.柯里化就是证明了函数只需要一个参数而已。其实我们刚才的学习过程中，已经涉及到了柯里化操作。
  *
  * 3.不用设立柯里化存在的意义这样的命题。柯里化就是以函数为主体这种思想发展的必然产生的结果。(即：柯里化是面向函数思想的必然产生结果)
  */
object CoriolisDemo {
  /**
    * 函数柯里化快速入门
    * 编写一个函数，接收两个整数，可以返回两个数的乘积，要求:
    *
    * 1.使用常规的方式完成
    * 2.使用闭包的方式完成
    * 3.使用函数柯里化完成
    */
  def main(args: Array[String]): Unit = {
    //观察编程方式的变化
    //说明
    def mul(x: Int, y: Int) = x * y
    println(mul(10, 10))

    def mulCurry(x: Int) = (y: Int) => x * y
    println(mulCurry(10)(9))

    def mulCurry2(x: Int)(y:Int) = x * y
    println(mulCurry2(10)(8))

    /**
      * 函数柯里化最佳实践
      *
      * 比较两个字符串在忽略大小写的情况下是否相等，注意，这里是两个任务：
      * 1.全部转大写（或小写）
      * 2.比较是否相等
      * 针对这两个操作，我们用一个函数去处理的思想，其实也变成了两个函数处理的思想（柯里化）
      */
    //方式1: 简单的方式,使用一个函数完成.
    def eq2(s1: String)(s2: String): Boolean = {
      s1.toLowerCase == s2.toLowerCase
    }

    //方式2：使用稍微高级的用法(隐式类)：形式为 str.方法()

    def eq(s1: String, s2: String): Boolean = {
      s1.equals(s2)}
    implicit class TestEq(s: String) {
      def checkEq(ss: String)(f: (String, String) => Boolean): Boolean = {
        f(s.toLowerCase, ss.toLowerCase)
      }}

    //案例演示+说明+简化版(三种形式，直接传入匿名函数方式)
    val str1 = "hello"
    str1.checkEq("Hello")(_.equals(_))//str1.checkEq("Hello")((s1: String, s2: String)=>s1.equals(s2)))
                                          // --> str1.checkEq("Hello")((s1, s2)=>s1.equals(s2)))
                                          // --> str1.checkEq("Hello")(_.equals(_))

  }
}
