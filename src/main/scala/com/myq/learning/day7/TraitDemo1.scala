package com.myq.learning.day7

/**
  * 特质---动态混入
  *
  * 1.除了可以在类声明时继承特质以外，还可以在构建对象时混入特质，扩展目标类的功能【反编译看动态混入本质】
  * 2.此种方式也可以应用于对抽象类功能进行扩展
  * 3.动态混入是Scala特有的方式（java没有动态混入），可在不修改类声明/定义的情况下，扩展类的功能，非常的灵活，耦合性低 。
  * 4.动态混入可以在不影响原有的继承关系的基础上，给指定的类扩展功能
  */
object TraitDemo1 {
  def main(args: Array[String]): Unit = {
    var oracle = new OracleDB with Operate3
    oracle.insert(999)
    val mysql = new MySQL3 with Operate3
    mysql.insert(4)
  }
}

trait Operate3 {
  def insert(id: Int): Unit = {
    println("插入数据 = " + id)
  }
}

class OracleDB {
}

abstract class MySQL3 {
}


