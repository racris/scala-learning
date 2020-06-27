package com.myq.learning.day8

/**
  * 隐式类
  *
  * 隐式类使用有如下几个特点：
  *
  * 1.其所带的构造参数有且只能有一个
  * 2.隐式类必须被定义在“类”或“伴生对象”或“包对象”里，即隐式类不能是 顶级的(top-level  objects)。
  * 3.隐式类不能是case class（case class在后续介绍 样例类）
  * 4.作用域内不能有与之相同名称的标识符
  */
object ImplicitClassDemo {
  def main(args: Array[String]): Unit = {
    //DB1会对应生成隐式类
    implicit class DB1(val m: MySQL1) {
      def addSuffix(): String = {
        m + " scala"
      }
    }
    val mysql1 = new MySQL1
    mysql1.sayOk()
    //mysql1.addSuffix() ==> DB1$1(mysql1).addSuffix()
    //DB1$1(mysql1)返回的类型是 ImplicitClass$DB1$2
    println(mysql1.addSuffix())

  }
}

class MySQL1 {
  def sayOk(): Unit = {
    println("sayOk")
  }
}

/**
  * 隐式的转换时机:
  * 当方法中的参数的类型与目标类型不一致时
  * 当对象调用所在类中不存在的方法或成员时，编译器会自动将对象进行隐式转换（根据类型）
  */

/**
  * 隐式解析机制
  *
  * 即编译器是如何查找到缺失信息的，解析具有以下两种规则：
  * 首先会在当前代码作用域下查找隐式实体（隐式方法、隐式类、隐式对象）。(一般是这种情况)
  * 如果第一条规则查找隐式实体失败，会继续在隐式参数的类型的作用域里查找。类型的作用域是指与该类型相关联的全部伴生模块，一个隐式实体的类型T它的查找范围如下(第二种情况范围广且复杂在使用时，应当尽量避免出现)：
  * a)  如果T被定义为T with A with B with C,那么A,B,C都是T的部分，在T的隐式解析过程中，它们的伴生对象都会被搜索。
  * b)  如果T是参数化类型，那么类型参数和与类型参数相关联的部分都算作T的部分，比如List[String]的隐式搜索会搜索List的伴生对象和String的伴生对象。
  * c)  如果T是一个单例类型p.T，即T是属于某个p对象内，那么这个p对象也会被搜索。
  * d)  如果T是个类型注入S#T，那么S和T都会被搜索。
  */

/**
  * 隐式转换的前提
  * 在进行隐式转换时，需要遵守两个基本的前提：
  *
  * 不能存在二义性
  * 隐式操作不能嵌套使用 // [举例：]如:隐式转换函数
  */