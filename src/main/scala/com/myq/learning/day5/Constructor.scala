package com.myq.learning.day5
//构造器
object Constructor {

  def main(args: Array[String]): Unit = {
    val p = new Person1("lili",20)
    println(p.toString)
  }
}

//主构造器格式
class Person1(inName:String,inAge:Int){
  var name = inName
  var age = inAge

}
/**
  * Scala构造器注意事项和细节
  *
  *
  *1. Scala构造器作用是完成对新对象的初始化，构造器没有返回值。
  *2. 主构造器的声明直接放置于类名之后 [反编译]
  *
  * 3.主构造器会执行类定义中的所有语句，这里可以体会到Scala的函数式编程和面向对象编程融合在一起，即：构造器也是方法（函数），
  * 传递参数和使用方法和前面的函数部分内容没有区别【案例演示+反编译】
  * 4.如果主构造器无参数，小括号可省略，构建对象时调用的构造方法的小括号也可以省略
  * 5.辅助构造器名称为this（这个和Java是不一样的），多个辅助构造器通过不同参数列表进行区分， 在底层就是f构造器重载。
  * 6.如果想让主构造器变成私有的，可以在()之前加上private，这样用户只能通过辅助构造器来构造对象了
  * 7.辅助构造器的声明不能和主构造器的声明一致,会发生错误(即构造器名重复)
  * 代码见Constructor1.scala,Constructor2.scala
  */