package com.myq.learning.day7

/**
  * 动态混入--叠加特质
  *
  * 1.Scala在叠加特质的时候，会首先从后面的特质开始执行
  * 2.Scala中特质中如果调用super，并不是表示调用父特质的方法，而是向前面（左边）继续查找特质，如果找不到，才会去父特质查找
  *
  * 叠加特质注意事项和细节：
  * 1.特质声明顺序从左到右。
  * 2.Scala在执行叠加对象的方法时，会首先从后面的特质(从右向左)开始执行
  * 3.Scala中特质中如果调用super，并不是表示调用父特质的方法，而是向前面（左边）继续查找特质，如果找不到，才会去父特质查找
  * 4.如果想要调用具体特质的方法，可以指定：super[特质].xxx(…).其中的泛型必须是该特质的直接超类类型
  */
object TraitDemo2 {
  def main(args: Array[String]): Unit = {
    val mysql = new MySQL4 with DB4 with File4
    //val mysql = new MySQL4 with File4 with DB4
    mysql.insert(888)

  }
}

trait Operate4 {
  println("Operate4...")
  def insert(id : Int)
}
trait Data4 extends Operate4 {
  println("Data4")
  override  def insert(id : Int): Unit = {
    println("插入数据 = " + id)
  }
}
trait DB4 extends Data4 {
  println("DB4")
  override def insert(id : Int): Unit = {
    print("向数据库")
    super.insert(id)
  }
}
trait File4 extends  Data4 {
  println("File4")
  override def insert(id : Int): Unit = {
    print("向文件")
    super.insert(id)
  }}
class MySQL4 {}

/**
  * 理解 abstract override 的小技巧分享：
  * 可以这里理解，当我们给某个方法增加了abstract override 后，就是明确的告诉编译器，该方法确实是重写了父特质的抽象方法，
  * 但是重写后，该方法仍然是一个抽象方法（因为没有完全的实现，需要其它特质继续实现[通过混入顺序]）
  */
/**
  * 富接口 -- 当作富接口使用的特质
  *
  * 富接口：即该特质中既有抽象方法，又有非抽象方法
  */

/**
  * 特质构造顺序
  *
  * 介绍
  * 特质也是有构造器的，构造器中的内容由“字段的初始化”和一些其他语句构成。具体实现请参考“特质叠加”
  *
  * 第一种特质构造顺序(声明类的同时混入特质)
  *
  * 1.调用当前类的超类构造器
  * 2.第一个特质的父特质构造器
  * 3.第一个特质构造器
  * 4.第二个特质构造器的父特质构造器, 如果已经执行过，就不再执行
  * 5.第二个特质构造器
  * 6........重复4,5的步骤(如果有第3个，第4个特质)
  * 7.当前类构造器
  */
trait AA {
  println("A...")
}
trait BB extends  AA {
  println("B....")
}
trait CC extends  BB {
  println("C....")
}
trait DD extends  BB {
  println("D....")
}
class EE {
  println("E...")
}
class FF extends EE with CC with DD {
  println("F....")
}
class KK extends EE {
  println("K....")
}
/**
  * 第2种特质构造顺序(在构建对象时，动态混入特质)
  * 1.调用当前类的超类构造器
  * 2.当前类构造器
  * 3.第一个特质构造器的父特质构造器
  * 4.第一个特质构造器.
  * 5.第二个特质构造器的父特质构造器, 如果已经执行过，就不再执行
  * 6.第二个特质构造器
  * 7........重复5,6的步骤(如果有第3个，第4个特质)
  * 8.当前类构造器
  *
  * 分析两种方式对构造顺序的影响
  * 第1种方式实际是构建类对象, 在混入特质时，该对象还没有创建。
  * 第2种方式实际是构造匿名子类，可以理解成在混入特质时，对象已经创建了。
  */