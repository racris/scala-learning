package com.myq.learning.day14

/**
  * java中上界
  * 在 Java 泛型里表示某个类型是 A 类型的子类型，使用 extends 关键字，这种形式叫 upper bounds(上限或上界)，语法如下：
  *
  * <T extends A>
  * //或用通配符的形式：
  * <? extends A>
  *
  * 上界(Upper Bounds)介绍和使用
  * scala中上界
  * 在 scala 里表示某个类型是 A 类型的子类型，也称上界或上限，使用 <: 关键字，语法如下：
  *
  * [T <: A]
  * //或用通配符:
  * [_ <: A]
  */
object UpperBoundsDemo {
  /**
    * 上界(Upper Bounds)介绍和使用
    * scala中上界应用案例-要求
    *
    * 编写一个通用的类，可以进行Int之间、Float之间、等实现了Comparable接口的值直接的比较.//java.lang.Integer
    * 分别使用传统方法和上界的方式来完成，体会上界使用的好处.
    *
    * @param args
    */
  def main(args: Array[String]): Unit = {
    //常规方式
    /*
    val compareInt = new CompareInt(-10, 2)
    println("res1=" + compareInt.greater)
    val compareFloat = new CompareFloat(-10.0f, -20.0f)
    println("res2=" + compareFloat.greater)*/
    /*val compareComm1 = new CompareComm(20, 30)
    println(compareComm1.greater)*/
    val compareComm2 = new CompareComm(Integer.valueOf(20), Integer.valueOf(30))
    println(compareComm2.greater)
    val compareComm3 =
      new CompareComm(java.lang.Float.valueOf(20.1f), java.lang.Float.valueOf(30.1f))
    println(compareComm3.greater)
    val compareComm4 = new CompareComm[java.lang.Float](201.9f, 30.1f)
    println(compareComm4.greater)


    biophony(Seq(new Bird, new Bird)) //?
    biophony(Seq(new Animal, new Animal)) //?
    biophony(Seq(new Animal, new Bird)) //?
//    biophony(Seq(new Earth, new Earth)) // 这个是错误的，因为使用了上界

  }

  def biophony[T <: Animal](things: Seq[T]) = things map (_.sound)

}

class CompareInt(n1: Int, n2: Int) {
  def greater = if(n1 > n2) n1 else n2
}

//使用上界的方式，可以有更好的通用性
class CompareComm[T <: Comparable[T]](obj1: T, obj2: T) {
  def greater = if(obj1.compareTo(obj2) > 0) obj1 else obj2
}

class Earth { //Earth 类
  def sound(){ //方法
    println("hello !")
  }}
class Animal extends Earth{
  override def sound() ={ //重写了Earth的方法sound()
    println("animal sound")
  }}
class Bird extends Animal{
  override def sound()={ //将Animal的方法重写
    print("bird sounds")
  }}
