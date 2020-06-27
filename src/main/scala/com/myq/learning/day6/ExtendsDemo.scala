package com.myq.learning.day6

/**
  * 要测试某个对象是否属于某个给定的类，可以用isInstanceOf方法。用asInstanceOf方法将引用转换为子类的引用。classOf获取对象的类名。
  */
object ExtendsDemo {

  /**
    * 1.classOf[String]就如同Java的 String.class 。
    * 2.obj.isInstanceOf[T]就如同Java的obj instanceof T 判断obj是不是T类型。
    * 3.obj.asInstanceOf[T]就如同Java的(T)obj 将obj强转成T类型。
    */
  def main(args: Array[String]): Unit = {
    // 获取对象类型
    println(classOf[String])
    val s = "zhangsan"
    println(s.getClass.getName)
    //这种是Java中反射方式得到类型
    println(s.isInstanceOf[String])
    println(s.asInstanceOf[String])
    //将s 显示转换成String
    var p = new Person2
    val e = new Emp
    p = e
    //将子类对象赋给父类。
    p.name = "xxx"
    println(e.name)
    p.asInstanceOf[Emp].sayHi()

  }

  class Person2{
    var name = ""

  }

  class Emp extends Person2{
    def sayHi(): Unit ={

    }
  }
}
