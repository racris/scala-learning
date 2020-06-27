package com.myq.learning.day6

/**
  * 基本介绍:
  * 在Scala中，通过abstract关键字标记不能被实例化的类。方法不用标记abstract，只要省掉方法体即可。抽象类可以拥有抽象字段，
  * 抽象字段/属性就是没有初始值的字段
  */
object AbstractDemo {

}

/**
  * Scala抽象类使用的注意事项和细节讨论
  * 1.抽象类不能被实例
  * 2.抽象类不一定要包含abstract方法。也就是说,抽象类可以没有abstract方法
  * 3.一旦类包含了抽象方法或者抽象属性,则这个类必须声明为abstract
  *
  * 4.抽象方法不能有主体，不允许使用abstract修饰。
  * 5.如果一个类继承了抽象类，则它必须实现抽象类的所有抽象方法和抽象属性，除非它自己也声明为abstract类。【案例演示+反编译】
  * 6.抽象方法和抽象属性不能使用private、final 来修饰，因为这些关键字都是和重写/实现相违背的。
  * 7.抽象类中可以有实现的方法.
  * 8.子类重写抽象方法不需要override，写上也不会错.
  */
abstract class Animal{
  var name : String //抽象的字段
  var age : Int // 抽象的字段
  var color : String = "black"
  def cry()   //抽象方法，不需要关键字abstract
}

/**
  * 覆写字段：
  * 覆写字段的注意事项和细节
  * 1.def只能重写另一个def(即：方法只能重写另一个方法)
  * 2.val只能重写另一个val 属性 或 重写不带参数的def
  * 3.var只能重写另一个抽象的var属性
  *
  * 抽象属性：声明未初始化的变量就是抽象的属性,抽象属性在抽象类：
  * --var重写抽象的var属性小结
  *
  * 1.一个属性没有初始化，那么这个属性就是抽象属性
  * 2.抽象属性在编译成字节码文件时，属性并不会声明，但是会自动生成抽象方法，所以类必须声明为抽象类
  * 3.如果是覆写一个父类的抽象属性，那么override 关键字可省略 [原因：父类的抽象属性，生成的是抽象方法，因此就不涉及到方法重写的概念，
  *   因此override可省略]
  */
//下面代码有误，与第二条不符
/*class AAAA {
  var name: String = ""
}
class BBBB extends AAAA {
  override  val name: String = "jj"
}*/
//下面代码ok
/*class A {
  def sal(): Int = {
    return 10
  }}

class B extends A {
  override val sal : Int = 0
}*/


