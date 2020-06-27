package com.myq.learning.day4

object Recursive {

  //递归的案例demo
  def main(args: Array[String]): Unit = {
    test(4)
    test1
  }

  def test(n: Int): Unit = {
    if (n > 2) {
      test(n - 1)
    }
    println("n=" + n)
  }

  /**
    * 函数递归需要遵守的重要原则（总结）
    * 1.程序执行一个函数时，就创建一个新的受保护的独立空间（新函数栈）
    * 2.函数的局部变量是独立的，不会相互影响
    * 3.递归必须向退出的递归条件逼近，否则就是无限递归，死循环
    * 4.当一个函数执行完毕，或者遇到return，就会返回，遵守谁调用，就将结果返回给谁
    */

  def test1{
    println("test")
  }

  //以下代码编译报错，递归不能使用类型推断，必须指定返回的数据类型
  /*def f(n:Int): Unit ={
    if(n==0){
      1
    }else{
      2*f(n-1)
    }
  }*/
}
