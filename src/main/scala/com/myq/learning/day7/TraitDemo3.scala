package com.myq.learning.day7

/**
  * 自身类型
  * 说明
  * 自身类型：主要是为了解决特质的循环依赖问题，同时可以确保特质在不扩展某个类的情况下，依然可以做到限制混入该特质的类的类型。
  */
object TraitDemo3 {

}

//Logger就是自身类型特质
trait Logger {
  // 明确告诉编译器，我就是Exception,如果没有这句话，下面的getMessage不能调用
  this: Exception =>
  def log(): Unit ={
    // 既然我就是Exception, 那么就可以调用其中的方法
    println(getMessage)
  }
}
