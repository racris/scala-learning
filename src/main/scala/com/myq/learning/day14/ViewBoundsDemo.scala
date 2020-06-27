package com.myq.learning.day14

/**
  * 视图界定基本介绍
  *
  * <% 的意思是“view bounds”(视界)，它比<:适用的范围更广，除了所有的子类型，还允许隐式转换类型。
  *
  * def method [A <% B](arglist): R = ... 等价于:
  * def method [A](arglist)(implicit viewAB: A => B): R = ...
  * 或等价于:
  * implicit def conver(a:A): B = …
  *
  * <% 除了方法使用之外，class 声明类型参数时也可使用：
  * class A[T <% Int]
  */
object ViewBoundsDemo {
  // 隐式将Student -> Ordered[Person2]//放在object MyImplicit 中
  implicit def person22OrderedPerson2(person: Person2) = new Ordered[Person2]{
    override def compare(that: Person2): Int = person.age - that.age
  }

  def main(args: Array[String]): Unit = {
    /**
      * 视图界定应用案例1
      * //方式1
      * //同时，也支持前面学习过的上界使用的各种方式
      */
    val compareComm1 = new CompareCommA(20, 30) //
    println(compareComm1.greater)

    val compareComm2 = new CompareCommA(Integer.valueOf(20), Integer.valueOf(30))
    println(compareComm2.greater)

    val compareComm4 = new CompareCommA[java.lang.Float](201.9f, 30.1f)
    println(compareComm4.greater)
    //上面的小数比较，在视图界定的情况下，就可以这样写了
    val compareComm5 =
      new CompareCommA(201.9f, 310.1f)
    println(compareComm5.greater)

    /**
      * 视图界定应用案例2
      *
      * 说明: 使用视图界定的方式，比较两个Person对象的年龄大小。
      */
    val p1 = new Person("tom", 10)
    val p2 = new Person("jack", 20)
    val compareComm6 = new CompareComm2(p1, p2)
    println(compareComm6.getter)

    /**
      * 视图界定应用案例3
      * 说明: 自己写隐式转换结合视图界定的方式，比较两个Person对象的年龄大小。
      */
    val p11 = new Person2("tom", 110)
    val p21 = new Person2("jack", 20)
    val compareComm7 = new CompareComm3(p11, p21)
    println(compareComm7.geater)

  }
}

/**
  * <% 视图界定 view bounds
  * 会发生隐式转换
  */
class CompareCommA[T <% Comparable[T]](obj1: T, obj2: T) {
  def greater = if (obj1.compareTo(obj2) > 0) obj1 else obj2
}

class Person(val name: String, val age: Int) extends Ordered[Person] {
  override def compare(that: Person): Int = this.age - that.age

  override def toString: String = this.name + "\t" + this.age
}

class CompareComm2[T <% Ordered[T]](obj1: T, obj2: T) {
  def getter = if (obj1 > obj2) obj1 else obj2

  def geatter2 = if (obj1.compareTo(obj2) > 0) obj1 else obj2

}

class Person2(val name: String, val age: Int)  {
  override def toString = this.name + "\t" + this.age
}
class CompareComm3[T <% Ordered[T]](obj1: T, obj2: T) {
  def geater = if (obj1 > obj2) obj1 else obj2
}
