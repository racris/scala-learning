package com.myq.learning.day14

/**
  * 基本介绍
  *
  * 与 view bounds 一样 context bounds(上下文界定)也是隐式参数的语法糖。为语法上的方便， 引入了”上下文界定”这个概念
  */
object ContextBoundsDemo {

  /**
    * 上下文界定应用实例
    * 要求：使用上下文界定+隐式参数的方式，比较两个Person对象的年龄大小
    * 要求：使用Ordering实现比较
    */
  implicit val personComparetor = new Ordering[Person] {
    override def compare(p1: Person, p2: Person): Int =
      p1.age - p2.age
  }

  def main(args: Array[String]): Unit = {
    val p1 = new Person("mary", 30)
    val p2 = new Person("smith", 35)
    val compareComm4 = new CompareComm4(p1,p2)
    println(compareComm4.geatter)
    val compareComm5 = new CompareComm5(p1,p2)
    println(compareComm5.geatter)
    val compareComm6 = new CompareComm6(p1,p2)
    println(compareComm6.geatter)
  }
}

//方式1
class CompareComm4[T: Ordering](obj1: T, obj2: T)(implicit comparetor: Ordering[T]) {
  def geatter = if (comparetor.compare(obj1, obj2) > 0) obj1 else obj2
}
//方式2,将隐式参数放到方法内
class CompareComm5[T: Ordering](o1: T, o2: T) {
  def geatter = {
    def f1(implicit cmptor: Ordering[T]) = cmptor.compare(o1, o2)
    if (f1 > 0) o1 else o2
  }}
//方式3,使用implicitly语法糖，最简单(推荐使用)
class CompareComm6[T: Ordering](o1: T, o2: T) {
  def geatter = {
    //这句话就是会发生隐式转换，获取到隐式值 personComparetor
    val comparetor = implicitly[Ordering[T]]
    println("CompareComm6 comparetor" + comparetor.hashCode())
    if(comparetor.compare(o1, o2) > 0) o1 else o2
  }}
