package com.myq.learning.day12

/**
  * 基本介绍
  *
  * 1.在对符合某个条件，而不是所有情况进行逻辑操作时，使用偏函数是一个不错的选择
  * 2.将包在大括号内的一组case语句封装为函数，我们称之为偏函数，它只对会作用于指定类型的参数或指定范围值的参数实施计算，超出范围的值会忽略（未必会忽略，这取决于你打算怎样处理）
  *
  * 3.偏函数在Scala中是一个特质PartialFunction
  */
object PartialFunctionDemo {
  /**
    * 需求
    *
    * 给你一个集合val list = List(1, 2, 3, 4, "abc") ，请完成如下要求:
    * 1.将集合list中的所有数字+1，并返回一个新的集合
    * 2.要求忽略掉 非数字 的元素，即返回的 新的集合 形式为 (2, 3, 4, 5)
    *
    * 思路1-map+fliter方式:
    * val list = List(1, 2, 3, 4, "abc")
    * //思路1,使用map+fliter的思路
    * def f1(n:Any): Boolean = {
    *   n.isInstanceOf[Int]
    * }
    * def f2(n:Int): Int = {
    *   n + 1
    * }
    * def f3(n:Any): Int ={
    *   n.asInstanceOf[Int]
    * }
    * val list2 = list.filter(f1).map(f3).map(f2)
    * println("list2=" + list2)
    *
    * 思路2-模式匹配
    * def addOne( i : Int ): Int = {
    * i match {
    * case x:Int => x + 1
    * case _ => _
    * }
    * }
    * val list = List(1, 2, 3, 4, "abc")
    * val list2 = list.map(addOne2)
    * println("list2=" + list2)
    * 可改进成--》
    * def addOne2( i : Any ): Any = {
    * i match {
    * case x:Int => x + 1
    * case _ =>
    * }
    * }
    */

  def main(args: Array[String]): Unit = {
    val list = List(1, 2, 3, 4, "abc")
    //说明
    val addOne3= new PartialFunction[Any, Int] {
      def isDefinedAt(any: Any) = if (any.isInstanceOf[Int]) true else false
      def apply(any: Any) = any.asInstanceOf[Int] + 1
    }
    val list3 = list.collect(addOne3)
    println("list3=" + list3)

    /**
      * 偏函数简化形式
      * 声明偏函数，需要重写特质中的方法，有的时候会略显麻烦，而Scala其实提供了简单的方法
      */
    //简化形式1
    def f2: PartialFunction[Any, Int] = {
      case i: Int => i + 1 // case语句可以自动转换为偏函数
    }
    val list2 = List(1, 2, 3, 4,"ABC").collect(f2)

    //简化形式2
    val list4 = List(1, 2, 3, 4,"ABC").collect{ case i: Int => i + 1 }
    println(list4)

  }

  /**
    * 偏函数的小结
    *
    * 1.使用构建特质的实现类(使用的方式是PartialFunction的匿名子类)
    * 2.PartialFunction 是个特质(看源码)
    * 3.构建偏函数时，参数形式   [Any, Int]是泛型，第一个表示参数类型，第二个表示返回参数
    * 4.当使用偏函数时，会遍历集合的所有元素，编译器执行流程时先执行isDefinedAt()如果为true ,就会执行 apply, 构建一个新的Int 对象返回
    * 5.执行isDefinedAt() 为false 就过滤掉这个元素，即不构建新的Int对象.
    * 6.map函数不支持偏函数，因为map底层的机制就是所有循环遍历，无法过滤处理原来集合的元素
    * 7.collect函数支持偏函数
    */
}
