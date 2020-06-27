package com.myq.learning.day12

/**
  * 基本介绍
  *
  * 基本介绍：闭包就是一个函数和与其相关的引用环境组合的一个整体(实体)。
  */
object ClosureDemo {
  def main(args: Array[String]): Unit = {
    //1.用等价理解方式改写 2.对象属性理解
    def minusxy(x: Int) = (y: Int) => x - y

    //f函数就是闭包.
    val f = minusxy(20)
    println("f(1)=" + f(1)) // 19
    println("f(2)=" + f(2)) // 18
    /**
      * 代码小结
      * 1.第1点
      * (y: Int) => x – y
      * 返回的是一个匿名函数 ，因为该函数引用到到函数外的 x,那么  该函数和x整体形成一个闭包
      * 如：这里 val f = minusxy(20) 的f函数就是闭包
      *
      * 2.你可以这样理解，返回函数是一个对象，而x就是该对象的一个字段，他们共同形成一个闭包
      * 3.当多次调用f时（可以理解多次调用闭包），发现使用的是同一个x, 所以x不变。
      * 4.在使用闭包时，主要搞清楚返回函数引用了函数外的哪些变量，因为他们会组合成一个整体(实体),形成一个闭包
      */

    /**
      * 闭包的实践案例：
      * 请编写一个程序，具体要求如下
      * 编写一个函数 makeSuffix(suffix: String)  可以接收一个文件后缀名(比如.jpg)，并返回一个闭包
      * 调用闭包，可以传入一个文件名，如果该文件名没有指定的后缀(比如.jpg) ,则返回 文件名.jpg , 如果已经有.jpg后缀，则返回原文件名。
      * 要求使用闭包的方式完成
      * String.endsWith(xx)
      */
    val f1 = makeSuffix(".png")
    println(f1("test"))
    println(f1("apple.png"))
  }

  def makeSuffix(suffix: String) = {
    (fileName: String) => {
      if (fileName.endsWith(suffix)) fileName else fileName + suffix
    }
  }
  /**
    * 闭包总结
    *
    * 返回的匿名函数和 makeSuffix (suffix string) 的 suffix 变量 组合成一个闭包,因为 返回的函数引用到suffix这个变量
    * 如果使用传统的方法，也可以轻松实现这个功能，但是传统方法需要每次都传入 后缀名，比如 .jpg ,
    * 而闭包因为可以保留上次引用的某个值，所以我们传入一次就可以反复使用。
    */
}
