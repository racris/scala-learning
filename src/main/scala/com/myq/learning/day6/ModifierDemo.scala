package com.myq.learning.day6

/**
  * Scala中包的可见性和访问修饰符的使用:
  *
  * 1.当属性访问权限为默认时，从底层看属性是private的，但是因为提供了xxx_$eq()[类似setter]/xxx()[类似getter] 方法，
  * 因此从使用效果看是任何地方都可以访问)
  * 2.当方法访问权限为默认时，默认为public访问权限
  * 3.private为私有权限，只在类的内部和伴生对象中可用 【案例演示】
  * 4.protected为受保护权限，scala中受保护权限比Java中更严格，只能子类访问，同包无法访问 (编译器)
  * 5.在scala中没有public关键字,即不能用public显式的修饰属性和方法。
  * 6.包访问权限（表示属性有了限制。同时包也有了限制），这点和Java不一样，体现出Scala包使用的灵活性。
  */
class ModifierDemo {
  private[day6] val pname = "hello" // 增加包访问权限后，1.private同时起作用。不仅同类可以使用
  // 2. 同时com.atguigu.scala中包下其他类也可以使用(包括子包也可以访问)
  /**
    * 当然，也可以将可见度延展到上层包
    * private[atguigu] val description="zhangsan"
    * 说明：private也可以变化，比如protected[atguigu], 非常的灵活。
    */
}

object ModifierDemo {

}
