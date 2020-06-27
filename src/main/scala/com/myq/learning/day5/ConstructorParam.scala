package com.myq.learning.day5

import scala.beans.BeanProperty

object ConstructorParam {
  def main(args: Array[String]): Unit = {
    val worker1 = new Worker1("hello")
    worker1.name  //只能访问name
    val worker2 = new Worker2("hello")
    worker2.inName  //可以访问inName,只读，不能修改
    val worker3 = new Worker3("hello")
    worker3.inName  //可以访问inName,可读可修改
  }
}
/**
  * 构造器参数
  *
  * Scala类的主构造器的形参未用任何修饰符修饰，那么这个参数是局部变量。
  *
  * 如果参数使用val关键字声明，那么Scala会将参数作为类的私有的只读属性使用 【案例+反编译】
  * 如果参数使用var关键字声明，那么那么Scala会将参数作为类的成员属性使用,并会提供属性对应的xxx()[类似getter]/xxx_$eq()[类似setter]方法，
  * 即这时的成员属性是私有的，但是可读写。
  */
class Worker1(inName:String){
  var name = inName
}

class Worker2(val inName:String){
  var name = inName
}

class Worker3(var inName: String){
  var name = inName
}

/**
  * Bean属性
  * JavaBeans规范定义了Java的属性是像getXxx（）和setXxx（）的方法。许多Java工具（框架）都依赖这个命名习惯。为了Java的互操作性。
  * 将Scala字段加@BeanProperty时，这样会自动生成规范的 setXxx/getXxx 方法。这时可以使用 对象.setXxx() 和 对象.getXxx() 来调用属性。
  *
  * 注意:给某个属性加入@BeanPropetry注解后，会生成getXXX和setXXX的方法
  * 并且对原来底层自动生成类似xxx(),xxx_$eq()方法，没有冲突，二者可以共存。
  */
class Car {
  @BeanProperty var name: String = null
}
